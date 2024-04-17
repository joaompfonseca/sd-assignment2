package communication.message;

/**
 * Type of the exchanged messages.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageType {
    /**
     * Coach get team strengths (request).
     */
    public static final int COACH_GET_TEAM_STRENGTHS_REQUEST = 0;
    /**
     * Coach get team strengths (reply).
     */
    public static final int COACH_GET_TEAM_STRENGTHS_REPLY = 1;
    /**
     * Coach set team is match end (request).
     */
    public static final int COACH_SET_TEAM_IS_MATCH_END_REQUEST = 2;
    /**
     * Coach set team is match end (reply).
     */
    public static final int COACH_SET_TEAM_IS_MATCH_END_REPLY = 3;
    /**
     * Contestant seat down (request).
     */
    public static final int CONTESTANT_SEAT_DOWN_REQUEST = 4;
    /**
     * Contestant seat down (reply).
     */
    public static final int CONTESTANT_SEAT_DOWN_REPLY = 5;
    /**
     * Coach call contestants (request).
     */
    public static final int COACH_CALL_CONTESTANTS_REQUEST = 6;
    /**
     * Coach call contestants (reply).
     */
    public static final int COACH_CALL_CONTESTANTS_REPLY = 7;
    /**
     * Contestant follow coach advice (request).
     */
    public static final int CONTESTANT_FOLLOW_COACH_ADVICE_REQUEST = 8;
    /**
     * Contestant follow coach advice (reply).
     */
    public static final int CONTESTANT_FOLLOW_COACH_ADVICE_REPLY = 9;
    /**
     * Referee set rope position (request).
     */
    public static final int REFEREE_SET_ROPE_POSITION_REQUEST = 10;
    /**
     * Referee set rope position (reply).
     */
    public static final int REFEREE_SET_ROPE_POSITION_REPLY = 11;
    /**
     * Contestant get ready (request).
     */
    public static final int CONTESTANT_GET_READY_REQUEST = 12;
    /**
     * Contestant get ready (reply).
     */
    public static final int CONTESTANT_GET_READY_REPLY = 13;
    /**
     * Coach inform referee (request).
     */
    public static final int COACH_INFORM_REFEREE_REQUEST = 14;
    /**
     * Coach inform referee (reply).
     */
    public static final int COACH_INFORM_REFEREE_REPLY = 15;
    /**
     * Referee start trial (request).
     */
    public static final int REFEREE_START_TRIAL_REQUEST = 16;
    /**
     * Referee start trial (reply).
     */
    public static final int REFEREE_START_TRIAL_REPLY = 17;
    /**
     * Contestant pull the rope (request).
     */
    public static final int CONTESTANT_PULL_THE_ROPE_REQUEST = 18;
    /**
     * Contestant pull the rope (reply).
     */
    public static final int CONTESTANT_PULL_THE_ROPE_REPLY = 19;
    /**
     * Contestant am done (request).
     */
    public static final int CONTESTANT_AM_DONE_REQUEST = 20;
    /**
     * Contestant am done (reply).
     */
    public static final int CONTESTANT_AM_DONE_REPLY = 21;
    /**
     * Referee assert trial decision (request).
     */
    public static final int REFEREE_ASSERT_TRIAL_DECISION_REQUEST = 22;
    /**
     * Referee assert trial decision (reply).
     */
    public static final int REFEREE_ASSERT_TRIAL_DECISION_REPLY = 23;
    /**
     * Coach review notes (request).
     */
    public static final int COACH_REVIEW_NOTES_REQUEST = 24;
    /**
     * Coach review notes (reply).
     */
    public static final int COACH_REVIEW_NOTES_REPLY = 25;
    /**
     * Referee announce new game (request).
     */
    public static final int REFEREE_ANNOUNCE_NEW_GAME_REQUEST = 26;
    /**
     * Referee announce new game (reply).
     */
    public static final int REFEREE_ANNOUNCE_NEW_GAME_REPLY = 27;
    /**
     * Referee call trial (request).
     */
    public static final int REFEREE_CALL_TRIAL_REQUEST = 28;
    /**
     * Referee call trial (reply).
     */
    public static final int REFEREE_CALL_TRIAL_REPLY = 29;
    /**
     * Referee declare game winner (request).
     */
    public static final int REFEREE_DECLARE_GAME_WINNER_REQUEST = 30;
    /**
     * Referee declare game winner (reply).
     */
    public static final int REFEREE_DECLARE_GAME_WINNER_REPLY = 31;
    /**
     * Referee declare match winner (request).
     */
    public static final int REFEREE_DECLARE_MATCH_WINNER_REQUEST = 32;
    /**
     * Referee declare match winner (reply).
     */
    public static final int REFEREE_DECLARE_MATCH_WINNER_REPLY = 33;
    /**
     * Server shutdown (request).
     */
    public static final int SHUTDOWN_REQUEST = 100;
    /**
     * Server shutdown (reply).
     */
    public static final int SHUTDOWN_REPLY = 101;


    /**
     * Private constructor to hide the implicit public one.
     */
    private MessageType() {
    }
}
