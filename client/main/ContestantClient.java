package client.main;

import client.entities.TContestant;
import client.stubs.contestantsbench.ContestantsBenchStub;
import client.stubs.contestantsbench.IContestantsBenchStub;
import client.stubs.playground.IPlaygroundStub;
import client.stubs.playground.PlaygroundStub;
import configuration.Config;

/**
 * Client that encapsulates the contestant threads.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class ContestantClient {
    /**
     * Main method.
     * <p>
     * Configures stubs based on runtime arguments.
     * Initiates contestant threads and awaits their completion.
     *
     * @param args runtime arguments
     *             <ul>
     *                 <li>args[0]: ContestantsBench server hostname</li>
     *                 <li>args[1]: ContestantsBench server port number</li>
     *                 <li>args[2]: Playground server hostname</li>
     *                 <li>args[3]: Playground server port number</li>
     *             </ul>
     */
    public static void main(String[] args) {
        // Runtime arguments
        String cbHost, pgHost;
        int cbPort = -1, pgPort = -1;

        // Stubs
        IContestantsBenchStub cbStub;
        IPlaygroundStub pgStub;

        // Threads
        Thread[] tContestants = new Thread[2 * Config.N_CONTESTANTS_PER_TEAM];

        // Validate and parse runtime arguments
        if (args.length != 4) {
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

        // Instantiate stubs
        cbStub = new ContestantsBenchStub(cbHost, cbPort);
        pgStub = new PlaygroundStub(pgHost, pgPort);

        // Instantiate threads
        for (int team = 0; team < 2; team++) {
            for (int number = 0; number < Config.N_CONTESTANTS_PER_TEAM; number++) {
                tContestants[team * Config.N_CONTESTANTS_PER_TEAM + number] = new TContestant(cbStub, pgStub, team, number, Config.MAX_STRENGTH, Config.MAX_STRENGTH);
            }
        }

        // Start threads
        for (Thread tContestant : tContestants) {
            tContestant.start();
        }

        // Wait for threads to finish
        try {
            for (Thread tContestant : tContestants) {
                tContestant.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown stubs
        cbStub.shutdown();
        pgStub.shutdown();
    }
}
