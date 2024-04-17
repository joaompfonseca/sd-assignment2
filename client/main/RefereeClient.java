package client.main;

import client.entities.TContestant;
import client.entities.TReferee;
import client.stubs.contestantsbench.ContestantsBenchStub;
import client.stubs.contestantsbench.IContestantsBenchStub;
import configuration.Config;

/**
 * Client that encapsulates the referee thread.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class RefereeClient {
    /**
     * Main method.
     * <p>
     * Configures stubs based on runtime arguments.
     * Initiates referee thread and awaits its completion.
     *
     * @param args runtime arguments
     *             <ul>
     *                 <li>args[0]: Playground server hostname</li>
     *                 <li>args[1]: Playground server port number</li>
     *                 <li>args[2]: RefereeSite server hostname</li>
     *                 <li>args[3]: RefereeSite server port number</li>
     *             </ul>
     */
    public static void main(String[] args) {
        // Runtime arguments
        String pgHost, rsHost;
        int pgPort = -1, rsPort = -1;

        // Stubs
        IPlaygroundStub pgStub;
        IRefereeSiteStub rsStub;

        // Thread
        Thread tReferee;

        // Validate and parse runtime arguments
        if (args.length != 4) {
            System.err.println("Wrong number of parameters!");
            System.exit(1);
        }
        pgHost = args[0];
        try {
            pgPort = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("args[1] is not a number!");
            System.exit(1);
        }
        if ((pgPort < 4000) || (pgPort >= 65536)) {
            System.out.println("args[1] is not a valid port number!");
            System.exit(1);
        }
        rsHost = args[2];
        try {
            rsPort = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.err.println("args[3] is not a number!");
            System.exit(1);
        }
        if ((rsPort < 4000) || (rsPort >= 65536)) {
            System.err.println("args[3] is not a valid port number!");
            System.exit(1);
        }

        // Instantiate stubs
        pgStub = new PlaygroundStub(pgHost, pgPort);
        rsStub = new RefereeSiteStub(rsHost, rsPort);

        // Instantiate thread
        tReferee = new TReferee(pgStub, rsStub, Config.N_GAMES_PER_MATCH, Config.N_TRIALS_PER_GAME);

        // Start thread
        tReferee.start();

        // Wait for thread to finish
        try {
            tReferee.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown stubs
        pgStub.shutdown();
        rsStub.shutdown();
    }
}
