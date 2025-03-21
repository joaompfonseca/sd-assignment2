package client.stubs.generalrepository;

/**
 * Interface for the site in the general repository stub.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public interface IGeneralRepositoryStub_Site {
    /**
     * Set the new state of the coach when he waits for the referee.
     *
     * @param team      the team
     */
    void reviewNotes(int team);

    /**
     * Set the new state of the referee when he announces a new game.
     */
    void announceNewGame();

    /**
     * Set the new state of the referee when he calls a trial.
     */
    void callTrial();

    /**
     * Set the new state of the referee when he declares the game winner.
     *
     * @param team the team
     * @param knockout the knockout flag
     */
    void declareGameWinner(int team, boolean knockout);

    /**
     * Set the new state of the referee when he declares the match winner.
     *
     * @param team the team
     */
    void declareMatchWinner(int team);
}
