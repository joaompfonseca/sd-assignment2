package server.sharedRegions;

import communication.message.*;

/**
 * Interface for Referee Site.
 */
public class RefereeSiteInterface {

    /**
     * Reference to the Referee Site.
     */
    private final RefereeSite refereeSite;

    /**
     * Instantiation of the interface to the Referee Site.
     * @param refereeSite the Referee Site
     */
    public RefereeSiteInterface(RefereeSite refereeSite) {
        this.refereeSite = refereeSite;
    }

    /**
     * Process and reply a message.
     * @param inMessage the message to process
     * @return the reply
     */
    public Message processAndReply (Message inMessage) throws MessageException {

        Message outMessage = null;                  // outgoing message

        /* validation of the incoming message */

        switch (inMessage.getType()){
            case MessageType.REFEREE_ANNOUNCE_NEW_GAME_REQUEST, MessageType.REFEREE_CALL_TRIAL_REQUEST -> {
                break;
            }
            case MessageType.REFEREE_DECLARE_GAME_WINNER_REQUEST -> {
                MessageRefereeDeclareGameWinnerRequest tempMessage = (MessageRefereeDeclareGameWinnerRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.REFEREE_DECLARE_MATCH_WINNER_REQUEST -> {
                MessageRefereeDeclareMatchWinnerRequest tempMessage = (MessageRefereeDeclareMatchWinnerRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.COACH_REVIEW_NOTES_REQUEST -> {
                MessageCoachReviewNotesRequest tempMessage = (MessageCoachReviewNotesRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            default -> throw new MessageException("Invalid message type!", inMessage);
        }

        /* processing */

        switch (inMessage.getType()){
            case MessageType.REFEREE_ANNOUNCE_NEW_GAME_REQUEST -> {
                refereeSite.announceNewGame();
                outMessage = new MessageRefereeAnnounceNewGameReply();
                break;
            }
            case MessageType.REFEREE_CALL_TRIAL_REQUEST -> {
                refereeSite.callTrial();
                outMessage = new MessageRefereeCallTrialReply();
                break;
            }
            case MessageType.REFEREE_DECLARE_GAME_WINNER_REQUEST -> {
                MessageRefereeDeclareGameWinnerRequest tempMessage = (MessageRefereeDeclareGameWinnerRequest) inMessage;
                refereeSite.declareGameWinner(tempMessage.getTeam(), tempMessage.isKnockout());
                outMessage = new MessageRefereeDeclareGameWinnerReply();
                break;
            }
            case MessageType.REFEREE_DECLARE_MATCH_WINNER_REQUEST -> {
                MessageRefereeDeclareMatchWinnerRequest tempMessage = (MessageRefereeDeclareMatchWinnerRequest) inMessage;
                refereeSite.declareMatchWinner(tempMessage.getTeam());
                outMessage = new MessageRefereeDeclareMatchWinnerReply();
                break;
            }
            case MessageType.COACH_REVIEW_NOTES_REQUEST -> {
                MessageCoachReviewNotesRequest tempMessage = (MessageCoachReviewNotesRequest) inMessage;
                boolean reviewNotes = refereeSite.reviewNotes(tempMessage.getTeam());
                outMessage = new MessageCoachReviewNotesReply(reviewNotes);
                break;
            }
        }

        return outMessage;
    }
}
