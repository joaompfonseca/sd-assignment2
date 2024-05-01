package client.stubs.generalrepository;


import communication.ClientCom;
import communication.message.*;

/**
 *  Stub to the general repository.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
*/
public class GeneralReposStub implements IGeneralReposStub {
    /**
     * Server hostname.
     */
    private final String host;
    /**
     * Server port.
     */
    private final int port;

  /**
   *   Instantiation of a stub to the general repository.
   *
   * @param host hostname of the server
   * @param port port of the server
   */
  public GeneralReposStub(String host, int port) {
      this.host = host;
      this.port = port;
  }

  /**
   *   Operation initialization of the simulation.
   *
   *     @param fileName logging file name
   *     @param nIter number of iterations of the customer life cycle
   */

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

    @Override
    public void seatDown(int team, int id, boolean increaseStrength) {
        ClientCom com;
        MessageReposSeatDownRequest outMessage;
        MessageReposSeatDownReply inMessage;

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
        outMessage = new MessageReposSeatDownRequest(team, id, increaseStrength);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageReposSeatDownReply) com.readObject();
        if (inMessage.getType() != MessageType.REPOS_SEAT_DOWN_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void callContestants(int team) {
        ClientCom com;
        MessageReposCallContestantsRequest outMessage;
        MessageReposCallContestantsReply inMessage;

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
        outMessage = new MessageReposCallContestantsRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageReposCallContestantsReply) com.readObject();
        if (inMessage.getType() != MessageType.REPOS_CALL_CONTESTANTS_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void followCoachAdvice(int team, int id) {
        ClientCom com;
        MessageContestantFollowCoachAdviceRequest outMessage;
        MessageReposFollowCoachAdviceReply inMessage;

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
        outMessage = new MessageContestantFollowCoachAdviceRequest(team, id);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageReposFollowCoachAdviceReply) com.readObject();
        if (inMessage.getType() != MessageType.REPOS_FOLLOW_COACH_ADVICE_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

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

    @Override
    public void pullTheRope(int team, int contestant, boolean reduce) {
        ClientCom com;
        MessageReposPullTheRopeRequest outMessage;
        MessageReposPullTheRopeReply inMessage;

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
        outMessage = new MessageReposPullTheRopeRequest(team, contestant, reduce);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageReposPullTheRopeReply) com.readObject();
        if (inMessage.getType() != MessageType.REPOS_PULL_THE_ROPE_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

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

    @Override
    public void assertTrialDecision(int ropePosition) {
        ClientCom com;
        MessageReposAssertTrialDecisionRequest outMessage;
        MessageReposAssertTrialDecisionReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Outgoing message
        outMessage = new MessageReposAssertTrialDecisionRequest(ropePosition);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageReposAssertTrialDecisionReply) com.readObject();
        if (inMessage.getType() != MessageType.REPOS_ASSERT_TRIAL_DECISION_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void reviewNotes(int team) {
        ClientCom com;
        MessageCoachReviewNotesRequest outMessage;
        MessageReposReviewNotesReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Outgoing message
        outMessage = new MessageCoachReviewNotesRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageReposReviewNotesReply) com.readObject();
        if (inMessage.getType() != MessageType.REPOS_REVIEW_NOTES_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void announceNewGame() {
        ClientCom com;
        MessageRefereeAnnounceNewGameRequest outMessage;
        MessageRefereeAnnounceNewGameReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeAnnounceNewGameRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeAnnounceNewGameReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_ANNOUNCE_NEW_GAME_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void callTrial() {
        ClientCom com;
        MessageRefereeCallTrialRequest outMessage;
        MessageRefereeCallTrialReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeCallTrialRequest();
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeCallTrialReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_CALL_TRIAL_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void declareGameWinner(int team, boolean knockout) {
        ClientCom com;
        MessageRefereeDeclareGameWinnerRequest outMessage;
        MessageRefereeDeclareGameWinnerReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeDeclareGameWinnerRequest(team, knockout);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeDeclareGameWinnerReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_DECLARE_GAME_WINNER_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }

    @Override
    public void declareMatchWinner(int team) {
        ClientCom com;
        MessageRefereeDeclareMatchWinnerRequest outMessage;
        MessageRefereeDeclareMatchWinnerReply inMessage;

        // Open connection
        com = new ClientCom(host, port);
        while (!com.open()) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }

        // Outgoing message
        outMessage = new MessageRefereeDeclareMatchWinnerRequest(team);
        com.writeObject(outMessage);

        // Incoming message
        inMessage = (MessageRefereeDeclareMatchWinnerReply) com.readObject();
        if (inMessage.getType() != MessageType.REFEREE_DECLARE_MATCH_WINNER_REPLY) {
            System.err.println("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
            System.err.println(inMessage);
            System.exit(1);
        }

        // Close connection
        com.close();
    }
}
