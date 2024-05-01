package server.sharedRegions;

import communication.message.*;

/**
 * Interface for Contestants Bench.
 */
public class ContestantsBenchInterface {

    /**
     * Reference to the Contestants Bench.
     */
    private final ContestantsBench contestantsBench;

    /**
     * Instantiation of the interface to the Contestants Bench.
     *
     * @param contestantsBench the Contestants Bench
     */
    public ContestantsBenchInterface(ContestantsBench contestantsBench) {
        this.contestantsBench = contestantsBench;
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
            case MessageType.COACH_GET_TEAM_STRENGTHS_REQUEST -> {
                MessageCoachGetTeamStrengthsRequest tempMessage = (MessageCoachGetTeamStrengthsRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.COACH_SET_TEAM_IS_MATCH_END_REQUEST -> {
                MessageCoachSetTeamIsMatchEndRequest tempMessage = (MessageCoachSetTeamIsMatchEndRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.CONTESTANT_SEAT_DOWN_REQUEST -> {
                MessageContestantSeatDownRequest tempMessage = (MessageContestantSeatDownRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                if ((tempMessage.getStrength() < 1) || (tempMessage.getStrength() > 5))
                    throw new MessageException("Invalid strength!", inMessage);
                break;
            }
            case MessageType.COACH_CALL_CONTESTANTS_REQUEST -> {
                MessageCoachCallContestantsRequest tempMessage = (MessageCoachCallContestantsRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REQUEST -> {
                MessageContestantFollowCoachAdviceRequest tempMessage = (MessageContestantFollowCoachAdviceRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.SHUTDOWN_REQUEST -> {
                break;
            }
            default -> throw new MessageException("Invalid message type!", inMessage);
        }

        /* processing */

        switch (inMessage.getType()) {
            case MessageType.COACH_GET_TEAM_STRENGTHS_REQUEST -> {
                MessageCoachGetTeamStrengthsRequest tempMessage = (MessageCoachGetTeamStrengthsRequest) inMessage;
                int[] result = contestantsBench.getTeamStrengths(tempMessage.getTeam());
                outMessage = new MessageCoachGetTeamStrengthsReply(result);
                break;
            }
            case MessageType.COACH_SET_TEAM_IS_MATCH_END_REQUEST -> {
                MessageCoachSetTeamIsMatchEndRequest tempMessage = (MessageCoachSetTeamIsMatchEndRequest) inMessage;
                contestantsBench.setTeamIsMatchEnd(tempMessage.getTeam(), tempMessage.getIsMatchEnd());
                outMessage = new MessageCoachSetTeamIsMatchEndReply();
                break;
            }
            case MessageType.CONTESTANT_SEAT_DOWN_REQUEST -> {
                MessageContestantSeatDownRequest tempMessage = (MessageContestantSeatDownRequest) inMessage;
                int result = contestantsBench.seatDown(tempMessage.getContestant(), tempMessage.getTeam(), tempMessage.getStrength());
                outMessage = new MessageContestantSeatDownReply(result);
                break;
            }
            case MessageType.COACH_CALL_CONTESTANTS_REQUEST -> {
                MessageCoachCallContestantsRequest tempMessage = (MessageCoachCallContestantsRequest) inMessage;
                contestantsBench.callContestants(tempMessage.getTeam(), tempMessage.getSelected());
                outMessage = new MessageCoachCallContestantsReply();
                break;
            }
            case MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REQUEST -> {
                MessageContestantFollowCoachAdviceRequest tempMessage = (MessageContestantFollowCoachAdviceRequest) inMessage;
                boolean result = contestantsBench.followCoachAdvice(tempMessage.getContestant(), tempMessage.getTeam());
                outMessage = new MessageContestantFollowCoachAdviceReply(result);
                break;
            }
            case MessageType.SHUTDOWN_REQUEST -> {
                contestantsBench.shutdown();
                outMessage = new MessageShutdownReply();
                break;
            }
        }

        return outMessage;
    }
}
