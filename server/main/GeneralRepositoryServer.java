package server.main;

import communication.ServerCom;
import server.entities.GeneralRepositoryClientProxy;
import server.sharedregions.GeneralRepository;
import server.sharedregions.GeneralRepositoryInterface;
import configuration.Config;

import java.net.SocketTimeoutException;

/**
 * Server side of the General Repository of Information.
 */
public class GeneralRepositoryServer {
    /**
     * Flag signaling the service is active.
     */
    public static boolean waitConnection;

    /**
     * Main method.
     *
     * @param args runtime arguments
     *             args[0] - port nunber for listening to service requests
     */
    public static void main(String[] args) {
        GeneralRepository repos;                                            // general repository of information (service to be rendered)
        GeneralRepositoryInterface reposInter;                              // interface to the general repository of information
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

        repos = new GeneralRepository(Config.N_CONTESTANTS_PER_TEAM, Config.LOGS_FOLDER);                                   // service is instantiated
        reposInter = new GeneralRepositoryInterface(repos);                // interface to the service is instantiated
        scon = new ServerCom(portNumb);                               // listening channel at the public port is established
        scon.start();
        System.out.println("General Repository service has started!");
        System.out.println("Server listening on port " + portNumb);

        /* service requests processing */

        GeneralRepositoryClientProxy cliProxy;                                  // service provider agent

        waitConnection = true;
        while (waitConnection) {
            try {
                sconi = scon.accept();                                      // enter listening procedure
                cliProxy = new GeneralRepositoryClientProxy(sconi, reposInter);  // start a service provider agent to address
                cliProxy.start();                                           // the request of service
            } catch (SocketTimeoutException e) {
            }
        }
        scon.end();                                                         // operations termination
        System.out.println("Server was shutdown.");
    }

    /**
     * Private constructor to hide the implicit public one.
     */
    private GeneralRepositoryServer() {
    }
}
