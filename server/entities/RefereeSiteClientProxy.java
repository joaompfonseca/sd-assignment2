package server.entities;

import communication.ServerCom;
import communication.message.Message;
import communication.message.MessageException;
import server.sharedregions.RefereeSiteInterface;

/**
 * Service provider agent for access to the Referee Site.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class RefereeSiteClientProxy extends Thread {
    /**
     * Number of instantiated threads.
     */
    private static int nProxy = 0;

    /**
     * Communication channel.
     */
    private final ServerCom sconi;

    /**
     * Referee Site Interface.
     */
    private final RefereeSiteInterface refereeSiteInterface;

    /**
     * Referee Site Client Proxy instantiation.
     *
     * @param sconi                communication channel
     * @param refereeSiteInterface Referee Site Interface
     */
    public RefereeSiteClientProxy(ServerCom sconi, RefereeSiteInterface refereeSiteInterface) {
        super("RefereeSiteClientProxy_" + getProxyId());
        this.sconi = sconi;
        this.refereeSiteInterface = refereeSiteInterface;
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
            cl = Class.forName("server.entities.RefereeSiteClientProxy");
        } catch (ClassNotFoundException e) {
            System.out.println("Data type RefereeSiteClientProxy was not found!");
            System.exit(1);
        }
        synchronized (cl) {
            proxyId = nProxy;
            nProxy += 1;
        }
        return proxyId;
    }

    /**
     * Life cycle of the service provider agent.
     */
    @Override
    public void run() {
        Message inMessage = null,
                outMessage = null;

        inMessage = (Message) sconi.readObject();
        try {
            outMessage = refereeSiteInterface.processAndReply(inMessage);
        } catch (MessageException e) {
            System.out.println("Thread" + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMessageVal().toString());
            System.exit(1);
        }
        sconi.writeObject(outMessage);
        sconi.close();
    }
}
