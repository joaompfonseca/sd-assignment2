package client.stubs.refereesite;

/**
 * General interface for the referee site stub, that extends from the referee site stub interfaces for the
 * coach and the referee.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public interface IRefereeSiteStub extends IRefereeSiteStub_Coach, IRefereeSiteStub_Referee {
    /**
     * Shutdown the server.
     */
    void shutdown();
}
