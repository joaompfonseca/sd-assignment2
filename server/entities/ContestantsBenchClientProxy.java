package server.entities;

import communication.ServerCom;
import communication.message.Message;
import communication.message.MessageException;
import server.sharedregions.ContestantsBenchInterface;

/**
 * Service provider agent for access to the Contestants Bench.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class ContestantsBenchClientProxy extends Thread {
    /**
     * Number of instantiated threads.
     */
    private static int nProxy = 0;

    /**
     * Communication channel.
     */
    private final ServerCom sconi;

    /**
     * Contestants Bench Interface.
     */
    private final ContestantsBenchInterface contestantsBenchInterface;

    /**
     * Contestants Bench Client Proxy instantiation.
     *
     * @param sconi                     communication channel
     * @param contestantsBenchInterface Contestants Bench Interface
     */
    public ContestantsBenchClientProxy(ServerCom sconi, ContestantsBenchInterface contestantsBenchInterface) {
        super("ContestantsBenchClientProxy_" + getProxyId());
        this.sconi = sconi;
        this.contestantsBenchInterface = contestantsBenchInterface;
    }

    /**
     * Generation of the instantiation identifier.
     *
     * @return instantiation identifier
     */
    private static int getProxyId() {
        Class<?> cl = null;
        int proxyId;

        try {
            cl = Class.forName("server.entities.ContestantsBenchClientProxy");
        } catch (ClassNotFoundException e) {
            System.out.println("Data type ContestantsBenchClientProxy was not found!");
            System.exit(1);
        }
        synchronized (cl) {
            proxyId = nProxy;
            nProxy += 1;
        }
        return proxyId;
    }

    /**
     * Life cycle of the service provider.
     */
    @Override
    public void run() {
        Message inMessage = null,
                outMessage = null;

        inMessage = (Message) sconi.readObject();
        try {
            outMessage = contestantsBenchInterface.processAndReply(inMessage);
        } catch (MessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMessageVal().toString());
            System.exit(1);
        }
        sconi.writeObject(outMessage);
        sconi.close();
    }
}
