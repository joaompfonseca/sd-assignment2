package server.entities;

import communication.ServerCom;
import communication.message.Message;
import communication.message.MessageException;
import server.sharedRegions.GeneralReposInterface;

public class GeneralReposClientProxy extends Thread {

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
    private GeneralReposInterface generalReposInterface;

    /**
     *  General Repository Client Proxy instantiation.
     *
     *    @param sconi communication channel
     *    @param generalReposInterface General Repository Interface
     */
    public GeneralReposClientProxy(ServerCom sconi, GeneralReposInterface generalReposInterface) {
        super("GeneralReposProxy_" + getProxyId());
        this.sconi = sconi;
        this.generalReposInterface = generalReposInterface;
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
            cl = Class.forName ("server.entities.GeneralReposClientProxy");
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
            outMessage = generalReposInterface.processAndReply(inMessage);    // processing the request
        } catch (MessageException e) {
            e.printStackTrace();
            System.exit(1);
        }
        sconi.writeObject(outMessage);                                 // sending the service reply
        sconi.close();                                                // closing the communication channel
    }
}
