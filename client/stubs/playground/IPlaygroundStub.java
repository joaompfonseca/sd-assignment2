package client.stubs.playground;

/**
 * General interface for the playground stub, that extends from the playground stub interfaces for the
 * coach, the contestant and the referee.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public interface IPlaygroundStub extends IPlaygroundStub_Coach, IPlaygroundStub_Contestant, IPlaygroundStub_Referee {
    /**
     * Shutdown the server.
     */
    void shutdown();
}
