package client.stubs.refereesite;

import communication.ClientCom;
import communication.message.*;

/**
 * Implementation of the playground stub.
 * <p>
 * It instantiates a remote reference to the playground server.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class RefereeSiteStub implements IRefereeSiteStub {
    /**
     * Server hostname.
     */
    private String host;
    /**
     * Server port.
     */
    private int port;

    /**
     * Instantiation of the playground stub.
     *
     * @param host hostname of the server
     * @param port port of the server
     */
    public RefereeSiteStub(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Shutdown the server.
     */
    @Override
    public void shutdown() {
        ClientCom com;
        MessageShutdownRequest outMessage;
        MessageShutdownReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }

        // Outgoing message
        outMessage = new MessageShutdownRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageShutdownReply) com.readObject();
        if (inMessage.getType() != MessageType.SHUTDOWN_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The coach waits for the referee command.
     *
     * @param team the team of the coach
     * @return true if the match has not ended, false otherwise
     */
    @Override
    public boolean reviewNotes(int team) {
        ClientCom com;
        MessageCoachReviewNotesRequest outMessage;
        MessageCoachReviewNotesReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }

        // Outgoing message
        outMessage = new MessageCoachReviewNotesRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageCoachReviewNotesReply) com.readObject();
        if (inMessage.getType() != MessageType.COACH_REVIEW_NOTES_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();

        return inMessage.getKeepRunning();
    }

    /**
     * The referee announces a new game.
     */
    @Override
    public void announceNewGame() {
        ClientCom com;
        MessageRefereeAnnounceNewGameRequest outMessage;
        MessageRefereeAnnounceNewGameReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeAnnounceNewGameRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeAnnounceNewGameReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_ANNOUNCE_NEW_GAME_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The referee calls the trial. The referee waits for the coaches to be ready to receive the command to call the
     * trial. The coaches will know the match has not ended.
     */
    @Override
    public void callTrial() {
        ClientCom com;
        MessageRefereeCallTrialRequest outMessage;
        MessageRefereeCallTrialReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeCallTrialRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeCallTrialReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_CALL_TRIAL_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The referee declares the team that won the game.
     *
     * @param team     the team that won the game
     * @param knockout true if the game was a knockout, false otherwise
     */
    @Override
    public void declareGameWinner(int team, boolean knockout) {
        ClientCom com;
        MessageRefereeDeclareGameWinnerRequest outMessage;
        MessageRefereeDeclareGameWinnerReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeDeclareGameWinnerRequest(team, knockout);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeDeclareGameWinnerReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_DECLARE_GAME_WINNER_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The referee declares the team that won the match. The referee waits for the coaches to be ready to receive the
     * command to declare the match winner. The coaches will know the match has ended.
     *
     * @param team the team that won the match
     */
    @Override
    public void declareMatchWinner(int team) {
        ClientCom com;
        MessageRefereeDeclareMatchWinnerRequest outMessage;
        MessageRefereeDeclareMatchWinnerReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeDeclareMatchWinnerRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeDeclareMatchWinnerReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_DECLARE_MATCH_WINNER_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }
}