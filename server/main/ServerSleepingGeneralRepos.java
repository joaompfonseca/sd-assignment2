package server.main;

import communication.ServerCom;
import server.entities.GeneralReposClientProxy;
import server.sharedRegions.GeneralRepos;
import server.sharedRegions.GeneralReposInterface;

import java.net.SocketTimeoutException;

/**
 *   Server side of the General Repository of Information.
 */
public class ServerSleepingGeneralRepos {

    /**
     *  Number of contestants per team.
     */
    private final static int N_CONTESTANTS_PER_TEAM = 5;

    /**
     *  Flag signaling the service is active.
     */
    public static boolean waitConnection;

    /**
     *  Main method.
     *
     *    @param args runtime arguments
     *        args[0] - port nunber for listening to service requests
     */
    public static void main (String [] args) {
        GeneralRepos repos;                                            // general repository of information (service to be rendered)
        GeneralReposInterface reposInter;                              // interface to the general repository of information
        ServerCom scon, sconi;                                         // communication channels
        int portNumb = -1;                                             // port number for listening to service requests

        if (args.length != 1) {
            System.out.println("Wrong number of parameters!");
            System.exit(1);
        }
        try {
            portNumb = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("args[0] is not a number!");
            System.exit(1);
        }
        if ((portNumb < 4000) || (portNumb >= 65536)) {
            System.out.println("args[0] is not a valid port number!");
            System.exit(1);
        }

        /* service is established */

        repos = new GeneralRepos(N_CONTESTANTS_PER_TEAM,"logs");                                   // service is instantiated
        reposInter = new GeneralReposInterface(repos);                // interface to the service is instantiated
        scon = new ServerCom(portNumb);                               // listening channel at the public port is established
        scon.start();
        System.out.println("Service is established!");
        System.out.println("Server is listening for service requests.");

        /* service requests processing */

        GeneralReposClientProxy cliProxy;                                  // service provider agent

        waitConnection = true;
        while (waitConnection) {
            try{
                sconi = scon.accept();                                      // enter listening procedure
                cliProxy = new GeneralReposClientProxy(sconi, reposInter);  // start a service provider agent to address
                cliProxy.start();                                           // the request of service
            } catch (SocketTimeoutException e) {
            }
        }
        scon.end();                                                         // operations termination
        System.out.println("Server was shutdown.");
    }
}
