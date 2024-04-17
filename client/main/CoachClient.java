package client.main;

import client.entities.TCoach;
import client.stubs.contestantsbench.ContestantsBenchStub;
import client.stubs.contestantsbench.IContestantsBenchStub;
import client.stubs.playground.IPlaygroundStub;
import client.stubs.playground.PlaygroundStub;
import client.stubs.refereesite.IRefereeSiteStub;
import client.stubs.refereesite.RefereeSiteStub;
import configuration.Config;

/**
 * Client that encapsulates the coach threads.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class CoachClient {
    /**
     * Main method.
     * <p>
     * Configures stubs based on runtime arguments.
     * Initiates coach threads and awaits their completion.
     *
     * @param args runtime arguments
     *             <ul>
     *                 <li>args[0]: ContestantsBench server hostname</li>
     *                 <li>args[1]: ContestantsBench server port number</li>
     *                 <li>args[2]: Playground server hostname</li>
     *                 <li>args[3]: Playground server port number</li>
     *                 <li>args[4]: RefereeSite server hostname</li>
     *                 <li>args[5]: RefereeSite server port number</li>
     *             </ul>
     */
    public static void main(String[] args) {
        // Runtime arguments
        String cbHost, pgHost, rsHost;
        int cbPort = -1, pgPort = -1, rsPort = -1;

        // Stubs
        IContestantsBenchStub cbStub;
        IPlaygroundStub pgStub;
        IRefereeSiteStub rsStub;

        // Threads
        Thread[] tCoaches = new Thread[2];

        // Validate and parse runtime arguments
        if (args.length != 6) {
            System.err.println("Wrong number of parameters!");
            System.exit(1);
        }
        cbHost = args[0];
        try {
            cbPort = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("args[1] is not a number!");
            System.exit(1);
        }
        if ((cbPort < 4000) || (cbPort >= 65536)) {
            System.out.println("args[1] is not a valid port number!");
            System.exit(1);
        }
        pgHost = args[2];
        try {
            pgPort = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.err.println("args[3] is not a number!");
            System.exit(1);
        }
        if ((pgPort < 4000) || (pgPort >= 65536)) {
            System.err.println("args[3] is not a valid port number!");
            System.exit(1);
        }
        rsHost = args[4];
        try {
            rsPort = Integer.parseInt(args[5]);
        } catch (NumberFormatException e) {
            System.err.println("args[5] is not a number!");
            System.exit(1);
        }
        if ((rsPort < 4000) || (rsPort >= 65536)) {
            System.err.println("args[5] is not a valid port number!");
            System.exit(1);
        }

        // Instantiate stubs
        cbStub = new ContestantsBenchStub(cbHost, cbPort);
        pgStub = new PlaygroundStub(pgHost, pgPort);
        rsStub = new RefereeSiteStub(rsHost, rsPort);

        // Instantiate threads
        for (int team = 0; team < 2; team++) {
            tCoaches[team] = new TCoach(cbStub, pgStub, rsStub, team, Config.N_CONTESTANTS_PER_TEAM, Config.N_CONTESTANTS_PER_TRIAL, Math.random());
        }

        // Start threads
        for (Thread tCoach : tCoaches) {
            tCoach.start();
        }

        // Wait for threads to finish
        try {
            for (Thread tCoach : tCoaches) {
                tCoach.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown stubs
        cbStub.shutdown();
        pgStub.shutdown();
        rsStub.shutdown();
    }

    /**
     * Private constructor to hide the implicit public one.
     */
    private CoachClient() {
    }
}
