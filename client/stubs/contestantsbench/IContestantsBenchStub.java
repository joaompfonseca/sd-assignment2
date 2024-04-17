package client.stubs.contestantsbench;

/**
 * General interface for the contestants bench stub, that extends from the contestants bench stub interfaces for the
 * contestant and the coach.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public interface IContestantsBenchStub extends IContestantsBenchStub_Coach, IContestantsBenchStub_Contestant {
    /**
     * Shutdown the server.
     */
    void shutdown();
}
