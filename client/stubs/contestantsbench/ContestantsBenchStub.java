package client.stubs.contestantsbench;

import communication.ClientCom;
import communication.message.*;
import configuration.Config;

/**
 * Implementation of the contestants bench stub.
 * <p>
 * It instantiates a remote reference to the contestants bench server.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class ContestantsBenchStub implements IContestantsBenchStub {
    /**
     * Server hostname.
     */
    private final String host;
    /**
     * Server port.
     */
    private final int port;

    /**
     * Instantiation of the contestants bench stub.
     *
     * @param host hostname of the server
     * @param port port of the server
     */
    public ContestantsBenchStub(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Shutdown the server.
     */
    @Override
    public void shutdown() {
        ClientCom com;
        MessageShutdownRequest outMessage;
        MessageShutdownReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageShutdownRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageShutdownReply) com.readObject();
        if (inMessage.getType() != MessageType.SHUTDOWN_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.err.println("Expected: " + MessageType.SHUTDOWN_REPLY);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The coach gets the strengths of the contestants of his team. The coach waits until all his contestants are seated
     * down.
     *
     * @param team the team
     * @return the strengths of the team
     */
    @Override
    public int[] getTeamStrengths(int team) {
        ClientCom com;
        MessageCoachGetTeamStrengthsRequest outMessage;
        MessageCoachGetTeamStrengthsReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageCoachGetTeamStrengthsRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageCoachGetTeamStrengthsReply) com.readObject();
        if (inMessage.getType() != MessageType.COACH_GET_TEAM_STRENGTHS_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.err.println("Expected: " + MessageType.COACH_GET_TEAM_STRENGTHS_REPLY);
            System.exit(1);
        }
        if (inMessage.getStrengths() == null || inMessage.getStrengths().length != Config.N_CONTESTANTS_PER_TEAM) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid team strengths!");
            System.err.println(inMessage);
            System.err.println("Expected: " + Config.N_CONTESTANTS_PER_TEAM + " strengths");
            System.exit(1);
        }

        // Close connection
        com.close();

        return inMessage.getStrengths();
    }

    /**
     * The coach sets the match end flag to alert the contestants form his team that the match has ended.
     *
     * @param team       the team
     * @param isMatchEnd the match end flag
     */
    @Override
    public void setTeamIsMatchEnd(int team, boolean isMatchEnd) {
        ClientCom com;
        MessageCoachSetTeamIsMatchEndRequest outMessage;
        MessageCoachSetTeamIsMatchEndReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageCoachSetTeamIsMatchEndRequest(team, isMatchEnd);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageCoachSetTeamIsMatchEndReply) com.readObject();
        if (inMessage.getType() != MessageType.COACH_SET_TEAM_IS_MATCH_END_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.err.println("Expected: " + MessageType.COACH_SET_TEAM_IS_MATCH_END_REPLY);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The contestant seats down and waits for the coach to call him. The last contestant to seat down alerts the coach.
     * The contestant waits for the coach to select him. If the coach does not select him, the contestant increases his
     * strength and waits again.
     *
     * @param team       the team
     * @param contestant the contestant
     * @param strength   the strength of the contestant
     * @return the strength of the contestant
     */
    @Override
    public int seatDown(int team, int contestant, int strength) {
        ClientCom com;
        MessageContestantSeatDownRequest outMessage;
        MessageContestantSeatDownReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageContestantSeatDownRequest(team, contestant, strength);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageContestantSeatDownReply) com.readObject();
        if (inMessage.getType() != MessageType.CONTESTANT_SEAT_DOWN_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.err.println("Expected: " + MessageType.CONTESTANT_SEAT_DOWN_REPLY);
            System.exit(1);
        }
        if (inMessage.getStrength() < 1 || inMessage.getStrength() > Config.MAX_STRENGTH) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid contestant strength!");
            System.err.println(inMessage);
            System.err.println("Expected: 1 <= strength <= " + Config.MAX_STRENGTH);
            System.exit(1);
        }

        // Close connection
        com.close();

        return inMessage.getStrength();
    }

    /**
     * The coach calls the contestants selected for the trial. The coach waits for all his contestants to seat down.
     * The coach alerts the contestants that the team has been assembled.
     *
     * @param team     the team
     * @param selected the selected contestants
     */
    @Override
    public void callContestants(int team, boolean[] selected) {
        ClientCom com;
        MessageCoachCallContestantsRequest outMessage;
        MessageCoachCallContestantsReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageCoachCallContestantsRequest(team, selected);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageCoachCallContestantsReply) com.readObject();
        if (inMessage.getType() != MessageType.COACH_CALL_CONTESTANTS_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.err.println("Expected: " + MessageType.COACH_CALL_CONTESTANTS_REPLY);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The contestant follows the coach advice.
     *
     * @param team       the team
     * @param contestant the contestant
     * @return true if the match has not ended, false otherwise
     */
    @Override
    public boolean followCoachAdvice(int team, int contestant) {
        ClientCom com;
        MessageContestantFollowCoachAdviceRequest outMessage;
        MessageContestantFollowCoachAdviceReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageContestantFollowCoachAdviceRequest(team, contestant);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageContestantFollowCoachAdviceReply) com.readObject();
        if (inMessage.getType() != MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.err.println("Expected: " + MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REPLY);
            System.exit(1);
        }

        // Close connection
        com.close();

        return inMessage.getKeepRunning();
    }
}