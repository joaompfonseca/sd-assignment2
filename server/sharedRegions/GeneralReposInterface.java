package server.sharedRegions;

import communication.message.*;

/**
 * Interface for GeneralRepos.
 */
public class GeneralReposInterface {

    /**
     * Reference to the GeneralRepos.
     */
    private final GeneralRepos generalRepos;

    /**
     * Instantiation of the interface to the GeneralRepos.
     *
     * @param generalRepos the GeneralRepos
     */
    public GeneralReposInterface(GeneralRepos generalRepos) {
        this.generalRepos = generalRepos;
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
            case MessageType.REPOS_SEAT_DOWN_REQUEST -> {
                MessageReposSeatDownRequest tempMessage = (MessageReposSeatDownRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.REPOS_CALL_CONTESTANTS_REQUEST -> {
                MessageReposCallContestantsRequest tempMessage = (MessageReposCallContestantsRequest) inMessage;
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
            case MessageType.CONTESTANT_GET_READY_REQUEST -> {
                MessageContestantGetReadyRequest tempMessage = (MessageContestantGetReadyRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.COACH_INFORM_REFEREE_REQUEST -> {
                MessageCoachInformRefereeRequest tempMessage = (MessageCoachInformRefereeRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.REFEREE_START_TRIAL_REQUEST -> {
                break;
            }
            case MessageType.REPOS_PULL_THE_ROPE_REQUEST -> {
                MessageReposPullTheRopeRequest tempMessage = (MessageReposPullTheRopeRequest) inMessage;
                if ((tempMessage.getContestant() < 0) || (tempMessage.getContestant() >= 5))
                    throw new MessageException("Invalid contestant id!", inMessage);
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.CONTESTANT_AM_DONE_REQUEST -> {
                break;
            }
            case MessageType.REPOS_ASSERT_TRIAL_DECISION_REQUEST -> {
                break;
            }
            case MessageType.COACH_REVIEW_NOTES_REQUEST -> {
                MessageCoachReviewNotesRequest tempMessage = (MessageCoachReviewNotesRequest) inMessage;
                if ((tempMessage.getTeam() < 0) || (tempMessage.getTeam() >= 2))
                    throw new MessageException("Invalid team id!", inMessage);
                break;
            }
            case MessageType.REFEREE_ANNOUNCE_NEW_GAME_REQUEST -> {
                break;
            }
            case MessageType.REFEREE_CALL_TRIAL_REQUEST -> {
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
            case MessageType.SHUTDOWN_REQUEST -> {
                break;
            }
            default -> throw new MessageException("Invalid message type!", inMessage);
        }

        /* processing */

        switch (inMessage.getType()) {
            case MessageType.REPOS_SEAT_DOWN_REQUEST -> {
                    MessageReposSeatDownRequest tempMessage = (MessageReposSeatDownRequest) inMessage;
                generalRepos.seatDown(tempMessage.getTeam(), tempMessage.getContestant(), tempMessage.getStrength());
                outMessage = new MessageReposSeatDownReply();
                break;
            }
            case MessageType.REPOS_CALL_CONTESTANTS_REQUEST -> {
                MessageReposCallContestantsRequest tempMessage = (MessageReposCallContestantsRequest) inMessage;
                generalRepos.callContestants(tempMessage.getTeam());
                outMessage = new MessageReposCallContestantsReply();
                break;
            }
            case MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REQUEST -> {
                MessageContestantFollowCoachAdviceRequest tempMessage = (MessageContestantFollowCoachAdviceRequest) inMessage;
                generalRepos.followCoachAdvice(tempMessage.getTeam(), tempMessage.getContestant());
                outMessage = new MessageReposFollowCoachAdviceReply();
                break;
            }
            case MessageType.CONTESTANT_GET_READY_REQUEST -> {
                MessageContestantGetReadyRequest tempMessage = (MessageContestantGetReadyRequest) inMessage;
                generalRepos.getReady(tempMessage.getTeam(), tempMessage.getContestant());
                outMessage = new MessageContestantGetReadyReply();
                break;
            }
            case MessageType.COACH_INFORM_REFEREE_REQUEST -> {
                MessageCoachInformRefereeRequest tempMessage = (MessageCoachInformRefereeRequest) inMessage;
                generalRepos.informReferee(tempMessage.getTeam());
                outMessage = new MessageCoachInformRefereeReply();
                break;
            }
            case MessageType.REFEREE_START_TRIAL_REQUEST -> {
                generalRepos.startTrial();
                break;
            }
            case MessageType.REPOS_PULL_THE_ROPE_REQUEST -> {
                MessageReposPullTheRopeRequest tempMessage = (MessageReposPullTheRopeRequest) inMessage;
                generalRepos.pullTheRope(tempMessage.getTeam(), tempMessage.getContestant(), tempMessage.getReduce());
                outMessage = new MessageReposPullTheRopeReply();
                break;
            }
            case MessageType.CONTESTANT_AM_DONE_REQUEST -> {
                generalRepos.amDone();
                outMessage = new MessageContestantAmDoneReply();
                break;
            }
            case MessageType.REPOS_ASSERT_TRIAL_DECISION_REQUEST -> {
                MessageReposAssertTrialDecisionRequest tempMessage = (MessageReposAssertTrialDecisionRequest) inMessage;
                generalRepos.assertTrialDecision(tempMessage.getRopePosition());
                outMessage = new MessageReposAssertTrialDecisionReply();
                break;
            }
            case MessageType.COACH_REVIEW_NOTES_REQUEST -> {
                MessageCoachReviewNotesRequest tempMessage = (MessageCoachReviewNotesRequest) inMessage;
                generalRepos.reviewNotes(tempMessage.getTeam());
                outMessage = new MessageReposReviewNotesReply();
                break;
            }
            case MessageType.REFEREE_ANNOUNCE_NEW_GAME_REQUEST -> {
                generalRepos.announceNewGame();
                outMessage = new MessageRefereeAnnounceNewGameReply();
                break;
            }
            case MessageType.REFEREE_CALL_TRIAL_REQUEST -> {
                generalRepos.callTrial();
                outMessage = new MessageRefereeCallTrialReply();
                break;
            }
            case MessageType.REFEREE_DECLARE_GAME_WINNER_REQUEST -> {
                MessageRefereeDeclareGameWinnerRequest tempMessage = (MessageRefereeDeclareGameWinnerRequest) inMessage;
                generalRepos.declareGameWinner(tempMessage.getTeam(), tempMessage.isKnockout());
                outMessage = new MessageRefereeDeclareGameWinnerReply();
                break;
            }
            case MessageType.REFEREE_DECLARE_MATCH_WINNER_REQUEST -> {
                MessageRefereeDeclareMatchWinnerRequest tempMessage = (MessageRefereeDeclareMatchWinnerRequest) inMessage;
                generalRepos.declareMatchWinner(tempMessage.getTeam());
                outMessage = new MessageRefereeDeclareMatchWinnerReply();
                break;
            }
            case MessageType.SHUTDOWN_REPLY -> {
                generalRepos.shutdown();
                outMessage = new MessageShutdownReply();
                break;
            }
        }

        return outMessage;
    }
}
