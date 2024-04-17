package client.stubs.playground;

import communication.ClientCom;
import communication.message.*;

/**
 * Implementation of the playground stub.
 * <p>
 * It instantiates a remote reference to the playground server.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class PlaygroundStub implements IPlaygroundStub {
    /**
     * Server hostname.
     */
    private final String host;
    /**
     * Server port.
     */
    private final int port;

    /**
     * Instantiation of the playground stub.
     *
     * @param host hostname of the server
     * @param port port of the server
     */
    public PlaygroundStub(String host, int port) {
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
                Thread.sleep(10);
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
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The referee sets the rope position.
     *
     * @param ropePosition the rope position
     */
    @Override
    public void setRopePosition(int ropePosition) {
        ClientCom com;
        MessageRefereeSetRopePositionRequest outMessage;
        MessageRefereeSetRopePositionReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeSetRopePositionRequest(ropePosition);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeSetRopePositionReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_SET_ROPE_POSITION_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The last contestant from each team informs the coach that they are ready. The contestant waits for the trial to
     * start by the referee.
     *
     * @param team       the team
     * @param contestant the contestant
     */
    @Override
    public void getReady(int team, int contestant) {
        ClientCom com;
        MessageContestantGetReadyRequest outMessage;
        MessageContestantGetReadyReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageContestantGetReadyRequest(team, contestant);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageContestantGetReadyReply) com.readObject();
        if (inMessage.getType() != MessageType.CONTESTANT_GET_READY_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The coach waits for the contestants from his team to be ready. The last coach informs the referee that the team is
     * ready. The coach waits for the trial to be decided by the referee.
     *
     * @param team the team
     */
    @Override
    public void informReferee(int team) {
        ClientCom com;
        MessageCoachInformRefereeRequest outMessage;
        MessageCoachInformRefereeReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageCoachInformRefereeRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageCoachInformRefereeReply) com.readObject();
        if (inMessage.getType() != MessageType.COACH_INFORM_REFEREE_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The referee waits for the coaches to be ready to announce the start of the trial.
     */
    @Override
    public void startTrial() {
        ClientCom com;
        MessageRefereeStartTrialRequest outMessage;
        MessageRefereeStartTrialReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeStartTrialRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeStartTrialReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_START_TRIAL_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The contestant pulls the rope with a similar distance as his current strength. The contestant loses 1 unit of
     * strength after pulling the rope.
     *
     * @param team       the team
     * @param contestant the contestant
     * @param strength   the current strength
     * @return the updated strength
     */
    @Override
    public int pullTheRope(int team, int contestant, int strength) {
        ClientCom com;
        MessageContestantPullTheRopeRequest outMessage;
        MessageContestantPullTheRopeReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageContestantPullTheRopeRequest(team, contestant, strength);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageContestantPullTheRopeReply) com.readObject();
        if (inMessage.getType() != MessageType.CONTESTANT_PULL_THE_ROPE_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();

        return inMessage.getStrength();
    }

    /**
     * The last contestant informs the referee that the trial is over. The contestant waits for the referee to decide
     * the result of the trial.
     */
    @Override
    public void amDone() {
        ClientCom com;
        MessageContestantAmDoneRequest outMessage;
        MessageContestantAmDoneReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageContestantAmDoneRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageContestantAmDoneReply) com.readObject();
        if (inMessage.getType() != MessageType.CONTESTANT_AM_DONE_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    /**
     * The referee waits for the contestants to be done to decide the result of the trial.
     *
     * @return the rope position
     */
    @Override
    public int assertTrialDecision() {
        ClientCom com;
        MessageRefereeAssertTrialDecisionRequest outMessage;
        MessageRefereeAssertTrialDecisionReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeAssertTrialDecisionRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeAssertTrialDecisionReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_ASSERT_TRIAL_DECISION_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();

        return inMessage.getRopePosition();
    }
}