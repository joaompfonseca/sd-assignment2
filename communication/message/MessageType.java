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
     * Server shutdown (request).
     */
    public static final int SHUTDOWN_REQUEST = 100;
    /**
     * Server shutdown (reply).
     */
    public static final int SHUTDOWN_REPLY = 101;
}
