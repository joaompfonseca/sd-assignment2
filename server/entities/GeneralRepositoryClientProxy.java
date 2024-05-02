package server.entities;

import communication.ServerCom;
import communication.message.Message;
import communication.message.MessageException;
import server.sharedregions.GeneralRepositoryInterface;

/**
 * Service provider agent for access to the General Repository.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class GeneralRepositoryClientProxy extends Thread {

    /**
     * Number of instantiayed threads.
     */
    private static int nProxy = 0;

    /**
     * Communication channel.
     */
    private final ServerCom sconi;

    /**
     * General Repository Interface.
     */
    private final GeneralRepositoryInterface generalRepositoryInterface;

    /**
     * General Repository Client Proxy instantiation.
     *
     * @param sconi                      communication channel
     * @param generalRepositoryInterface General Repository Interface
     */
    public GeneralRepositoryClientProxy(ServerCom sconi, GeneralRepositoryInterface generalRepositoryInterface) {
        super("GeneralRepositoryClientProxy_" + getProxyId());
        this.sconi = sconi;
        this.generalRepositoryInterface = generalRepositoryInterface;
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
            cl = Class.forName("server.entities.GeneralRepositoryClientProxy");
        } catch (ClassNotFoundException e) {
            System.out.println("Data type GeneralRepositoryClientProxy was not found!");
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
            outMessage = generalRepositoryInterface.processAndReply(inMessage);
        } catch (MessageException e) {
            e.printStackTrace();
            System.exit(1);
        }
        sconi.writeObject(outMessage);
        sconi.close();
    }
}
