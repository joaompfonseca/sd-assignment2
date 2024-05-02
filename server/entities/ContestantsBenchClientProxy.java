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
     *  Number of instantiayed threads.
     */
    private static int nProxy = 0;

    /**
     *  Communication channel.
     */
    private ServerCom sconi;

    /**
     *  Contestants Bench Interface.
     */
    private ContestantsBenchInterface contestantsBenchInterface;

    /**
     *  Contestants Bench Client Proxy instantiation.
     *
     *    @param sconi communication channel
     *    @param contestantsBenchInterface Contestants Bench Interface
     */
    public ContestantsBenchClientProxy(ServerCom sconi, ContestantsBenchInterface contestantsBenchInterface) {
        super("ContestantsBenchClientProxy_" + getProxyId());
        this.sconi = sconi;
        this.contestantsBenchInterface = contestantsBenchInterface;
    }

    /**
     *  Generation of the instantiation identifier.
     *
     *     @return instantiation identifier
     */
    private static int getProxyId ()
    {
        Class<?> cl = null;                                            // representation of the BarberShopClientProxy object in JVM
        int proxyId;                                                   // instantiation identifier

        try {
            cl = Class.forName ("server.entities.ContestantsBenchClientProxy");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Data type ContestantsBenchProxy was not found!");
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
        Message inMessage = null,                                      // request message
               outMessage = null;                                     // response message

        inMessage = (Message) sconi.readObject();                               // reading the request message
        try {
            outMessage = contestantsBenchInterface.processAndReply(inMessage);    // processing
        } catch (MessageException e) {
            System.out.println("Thread " + getName() + ": " + e.getMessage() + "!");
            System.out.println(e.getMessageVal().toString());
            System.exit(1);
        }
        sconi.writeObject(outMessage);                                // sending the reply message
        sconi.close();                                                // closing the communication channel
    }
}
