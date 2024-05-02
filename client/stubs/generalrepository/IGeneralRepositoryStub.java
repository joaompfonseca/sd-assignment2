package client.stubs.generalrepository;

/**
 * General interface for the general repository stub.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public interface IGeneralRepositoryStub extends IGeneralRepositoryStub_Bench, IGeneralRepositoryStub_Playground, IGeneralRepositoryStub_Site {
    /**
     * Shutdown the server.
     */
    void shutdown();
}
