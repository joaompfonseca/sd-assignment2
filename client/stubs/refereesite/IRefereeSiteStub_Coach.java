package client.stubs.refereesite;

/**
 * Interface for the coach in the referee site stub.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public interface IRefereeSiteStub_Coach {
    /**
     * The coach waits for the referee command.
     *
     * @param team the team of the coach
     * @return true if the match has not ended, false otherwise
     */
    boolean reviewNotes(int team);
}
