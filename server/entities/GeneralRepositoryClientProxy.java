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
     *  Number of instantiayed threads.
     */
    private static int nProxy = 0;

    /**
     *  Communication channel.
     */
    private ServerCom sconi;

    /**
     *  General Repository Interface.
     */
    private GeneralRepositoryInterface generalRepositoryInterface;

    /**
     *  General Repository Client Proxy instantiation.
     *
     *    @param sconi communication channel
     *    @param generalRepositoryInterface General Repository Interface
     */
    public GeneralRepositoryClientProxy(ServerCom sconi, GeneralRepositoryInterface generalRepositoryInterface) {
        super("GeneralRepositoryClientProxy_" + getProxyId());
        this.sconi = sconi;
        this.generalRepositoryInterface = generalRepositoryInterface;
    }

    /**
     *  Generation of the instantiation identifier.
     *
     *     @return instantiation identifier
     */
    private static int getProxyId(){
        Class<?> cl = null;                                            // representation of the BarberShopClientProxy object in JVM
        int proxyId;                                                   // instantiation identifier

        try {
            cl = Class.forName ("server.entities.GeneralRepositoryClientProxy");
        } catch (ClassNotFoundException e) {
            System.out.println("Data type GeneralReposClientProxy was not found!");
            e.printStackTrace ();
            System.exit (1);
        }
        synchronized (cl) {
            proxyId = nProxy;
            nProxy += 1;
        }
        return proxyId;
    }

    /**
     *  Life cycle of the service provider.
     */
    @Override
    public void run() {
        Message inMessage = null,                                      // service request
                outMessage = null;                                     // service reply

        inMessage = (Message) sconi.readObject();                     // reading the service request
        try {
            outMessage = generalRepositoryInterface.processAndReply(inMessage);    // processing the request
        } catch (MessageException e) {
            e.printStackTrace();
            System.exit(1);
        }
        sconi.writeObject(outMessage);                                 // sending the service reply
        sconi.close();                                                // closing the communication channel
    }
}
