package server.sharedregions;

import communication.message.*;

/**
 * Interface for Playground.
 */
public class PlaygroundInterface {

    /**
     * Reference to the Playground.
     */
    private final Playground playground;

    /**
     * Instantiation of the interface to the Playground.
     *
     * @param playground the Playground
     */
    public PlaygroundInterface(Playground playground) {
        this.playground = playground;
    }

    /**
     * Process and reply a message.
     *
     * @param inMessage the message to process
     * @return the reply
     */
    public Message processAndReply(Message inMessage) throws MessageException {

        Message outMessage = null;                  // outgoing message

        /* validation of the incoming message */

        switch (inMessage.getType()) {
            case MessageType.REFEREE_SET_ROPE_POSITION_REQUEST: {
                break;
            }
            case MessageType.CONTESTANT_GET_READY_REQUEST: {
                MessageContestantGetReadyRequest tempMessage = (MessageContestantGetReadyRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.COACH_INFORM_REFEREE_REQUEST: {
                MessageCoachInformRefereeRequest tempMessage = (MessageCoachInformRefereeRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.REFEREE_START_TRIAL_REQUEST: {
                break;
            }
            case MessageType.CONTESTANT_PULL_THE_ROPE_REQUEST: {
                MessageContestantPullTheRopeRequest tempMessage = (MessageContestantPullTheRopeRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                if ((tempMessage.getStrength() < 1) || (tempMessage.getStrength() > 5))
                    throw new MessageException("Invalid strength!", inMessage);
                break;
            }
            case MessageType.CONTESTANT_AM_DONE_REQUEST: {
                break;
            }
            case MessageType.REFEREE_ASSERT_TRIAL_DECISION_REQUEST: {
                break;
            }
            case MessageType.SHUTDOWN_REQUEST: {
                break;
            }
            default:
                throw new MessageException("Invalid message type!", inMessage);
        }

        /* processing */

        switch (inMessage.getType()) {
            case MessageType.REFEREE_SET_ROPE_POSITION_REQUEST: {
                MessageRefereeSetRopePositionRequest tempMessage = (MessageRefereeSetRopePositionRequest) inMessage;
                playground.setRopePosition(tempMessage.getRopePosition());
                outMessage = new MessageRefereeSetRopePositionReply();
                break;
            }
            case MessageType.CONTESTANT_GET_READY_REQUEST: {
                MessageContestantGetReadyRequest tempMessage = (MessageContestantGetReadyRequest) inMessage;
                playground.getReady(tempMessage.getContestant(), tempMessage.getTeam());
                outMessage = new MessageContestantGetReadyReply();
                break;
            }
            case MessageType.COACH_INFORM_REFEREE_REQUEST: {
                MessageCoachInformRefereeRequest tempMessage = (MessageCoachInformRefereeRequest) inMessage;
                playground.informReferee(tempMessage.getTeam());
                outMessage = new MessageCoachInformRefereeReply();
                break;
            }
            case MessageType.REFEREE_START_TRIAL_REQUEST: {
                playground.startTrial();
                outMessage = new MessageRefereeStartTrialReply();
                break;
            }
            case MessageType.CONTESTANT_PULL_THE_ROPE_REQUEST: {
                MessageContestantPullTheRopeRequest tempMessage = (MessageContestantPullTheRopeRequest) inMessage;
                int result = playground.pullTheRope(tempMessage.getContestant(), tempMessage.getTeam(), tempMessage.getStrength());
                outMessage = new MessageContestantPullTheRopeReply(result);
                break;
            }
            case MessageType.CONTESTANT_AM_DONE_REQUEST: {
                playground.amDone();
                outMessage = new MessageContestantAmDoneReply();
                break;
            }
            case MessageType.REFEREE_ASSERT_TRIAL_DECISION_REQUEST: {
                int result = playground.assertTrialDecision();
                outMessage = new MessageRefereeAssertTrialDecisionReply(result);
                break;
            }
            case MessageType.SHUTDOWN_REQUEST: {
                playground.shutdown();
                outMessage = new MessageShutdownReply();
                break;
            }
        }

        return outMessage;
    }
}
