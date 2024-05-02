package server.main;

import client.stubs.generalrepository.GeneralRepositoryStub;
import server.sharedregions.Playground;
import communication.ServerCom;
import server.sharedregions.PlaygroundInterface;
import server.entities.PlaygroundClientProxy;
import configuration.Config;

import java.net.SocketTimeoutException;

/**
 * Server that encapsulates the referee site.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class PlaygroundServer {
    /**
     *  Flag signaling the service is active.
     */
    public static boolean waitConnection;

    /**
     *  Main method.
     *
     *    @param args runtime arguments
     *        args[0] - port number for listening to service requests
     *        args[1] - name of the platform where is located the server for the general repository
     *        args[2] - port number where the server for the general repository is listening to service requests
     */
    public static void main(String[] args) {
        Playground playground;                          // playground (service to be rendered)
        PlaygroundInterface playgroundInter;            // interface to the playground
        GeneralRepositoryStub reposStub;                     // stub to the general repository
        ServerCom scon, sconi;                          // communication channels
        int portNumb = -1;                              // port number for listening to service requests
        String reposServerName;                         // name of the platform where is located the server for the general repository
        int reposPortNumb = -1;                         // port number where the server for the general repository is listening to service requests

        if (args.length != 3) {
            System.err.println("Wrong number of parameters!");
            System.exit(1);
        }
        try {
            portNumb = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("args[0] is not a number!");
            System.exit(1);
        }
        if ((portNumb < 4000) || (portNumb >= 65536)) {
            System.out.println("args[0] is not a valid port number!");
            System.exit(1);
        }
        reposServerName = args[1];
        try {
            reposPortNumb = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("args[2] is not a number!");
            System.exit(1);
        }
        if ((reposPortNumb < 4000) || (reposPortNumb >= 65536)) {
            System.out.println("args[2] is not a valid port number!");
            System.exit(1);
        }

        /* service is established */

        reposStub = new GeneralRepositoryStub(reposServerName, reposPortNumb);
        playground = new Playground(Config.N_CONTESTANTS_PER_TRIAL, reposStub);
        playgroundInter = new PlaygroundInterface(playground);
        scon = new ServerCom(portNumb);
        scon.start();
        System.out.println("Playground service has started!");
        System.out.println("Server listening on port " + portNumb);

        /* service request processing */

        waitConnection = true;
        while (waitConnection) {
            try {
                sconi = scon.accept();
                PlaygroundClientProxy cliProxy = new PlaygroundClientProxy(sconi, playgroundInter);
                cliProxy.start();
            } catch (SocketTimeoutException e) {
            }
        }
        scon.end();
        System.out.println("Server service has ended!");
    }
}
