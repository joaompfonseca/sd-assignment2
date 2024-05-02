package server.sharedregions;

import client.stubs.generalrepository.GeneralRepositoryStub;
import server.main.RefereeSiteServer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Referee Site.
 */
public class RefereeSite {
    /**
     * The lock.
     */
    private final ReentrantLock lock;
    /**
     * The condition variable for coaches waiting.
     */
    private final Condition coachesWaited;
    /**
     * The number of coaches waiting.
     */
    private int waiting;
    /**
     * The condition variable for referee command.
     */
    private final Condition refereeCommand;
    /**
     * Flag to indicate if the referee has given a command.
     */
    private boolean isRefereeCommand;
    /**
     * Flag to indicate if the match has ended.
     */
    private boolean isMatchEnd;
    /**
     * The team that won the game.
     */
    private int winTeamGame;
    /**
     * The team that won the match.
     */
    private int winTeamMatch;
    /**
     * The general repository.
     */
    private final GeneralRepositoryStub reposStub;
    /**
     * Number of entity groups requesting the shutdown.
     */
    private int nEntities;

    /**
     * Instantiation of the referee site.
     *
     * @param reposStub the general repository
     */
    public RefereeSite(GeneralRepositoryStub reposStub) {
        this.reposStub = reposStub;
        lock = new ReentrantLock();
        coachesWaited = lock.newCondition();
        refereeCommand = lock.newCondition();
        waiting = 0;
        isRefereeCommand = false;
        isMatchEnd = false;
        winTeamGame = -1;
        winTeamMatch = -1;
        nEntities = 0;
    }

    /**
     * The coach waits for the referee command.
     *
     * @param team the team of the coach
     * @return true if the match has not ended, false otherwise
     */
    public boolean reviewNotes(int team) {
        lock.lock();
        try {
            waiting++;
            if (waiting == 2) {
                coachesWaited.signal(); // alerts referee
            }
            while (!isRefereeCommand) {
                refereeCommand.await(); // releases lock and waits for referee command
            }
            waiting--;
            if (waiting == 0) {
                isRefereeCommand = false;
            }
            reposStub.reviewNotes(team);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return !isMatchEnd;
    }

    /**
     * The referee announces a new game.
     */
    public void announceNewGame() {
        lock.lock();
        try {
            reposStub.announceNewGame();
        } finally {
            lock.unlock();
        }
    }

    /**
     * The referee calls the trial. The referee waits for the coaches to be ready to receive the command to call the
     * trial. The coaches will know the match has not ended.
     */
    public void callTrial() {
        lock.lock();
        try {
            while (waiting < 2) {
                coachesWaited.await(); // releases lock and waits for coaches
            }
            isMatchEnd = false;
            isRefereeCommand = true;
            reposStub.callTrial();
            refereeCommand.signalAll(); // alerts coaches
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * The referee declares the team that won the game.
     *
     * @param team     the team that won the game
     * @param knockout true if the game was a knockout, false otherwise
     */
    public void declareGameWinner(int team, boolean knockout) {
        lock.lock();
        try {
            winTeamGame = team;
            reposStub.declareGameWinner(team, knockout);
        } finally {
            lock.unlock();
        }
    }

    /**
     * The referee declares the team that won the match. The referee waits for the coaches to be ready to receive the
     * command to declare the match winner. The coaches will know the match has ended.
     *
     * @param team the team that won the match
     */
    public void declareMatchWinner(int team) {
        lock.lock();
        try {
            winTeamMatch = team;
            while (waiting < 2) {
                coachesWaited.await(); // releases lock and waits for coaches
            }
            waiting = 0;
            isMatchEnd = true;
            isRefereeCommand = true;
            reposStub.declareMatchWinner(team);
            refereeCommand.signalAll(); // alerts coaches
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Operation server shutdown.
     */
    public void shutdown() {
        lock.lock();
        try {
            nEntities += 1;
            if (nEntities >= 2) {
                reposStub.shutdown();
                RefereeSiteServer.waitConnection = false;
            }
        } finally {
            lock.unlock();
        }
    }
}
