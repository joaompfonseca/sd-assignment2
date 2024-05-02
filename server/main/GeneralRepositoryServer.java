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
     *             args[0] - port number for listening to service requests
     */
    public static void main(String[] args) {
        GeneralRepository repos;
        GeneralRepositoryInterface reposInter;
        ServerCom scon, sconi;
        int portNumb = -1;

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

        repos = new GeneralRepository(Config.N_CONTESTANTS_PER_TEAM, Config.LOGS_FOLDER);
        reposInter = new GeneralRepositoryInterface(repos);
        scon = new ServerCom(portNumb);
        scon.start();
        System.out.println("General Repository service has started!");
        System.out.println("Server listening on port " + portNumb);

        /* service requests processing */

        GeneralRepositoryClientProxy cliProxy;

        waitConnection = true;
        while (waitConnection) {
            try {
                sconi = scon.accept();
                cliProxy = new GeneralRepositoryClientProxy(sconi, reposInter);
                cliProxy.start();
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
            }
        }
        scon.end();
        System.out.println("General Repository service has ended!");
    }

    /**
     * Private constructor to hide the implicit public one.
     */
    private GeneralRepositoryServer() {
    }
}
