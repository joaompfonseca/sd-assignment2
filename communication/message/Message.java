package communication.message;

import java.io.Serial;
import java.io.Serializable;

/**
 * Generic internal structure of the exchanged messages.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class Message implements Serializable {
    /**
     * Serialization key.
     */
    @Serial
    private static final long serialVersionUID = 2024L;
    /**
     * Message type.
     */
    private int type = -1;
    /**
     * Team identification.
     */
    private int team = -1;
    /**
     * Team strengths.
     */
    private int[] strengths = null;
    /**
     * Match end flag.
     */
    private boolean isMatchEnd = false;
    /**
     * Contestant identification.
     */
    private int contestant = -1;
    /**
     * Contestant strength.
     */
    private int strength = -1;
    /**
     * Selected contestants.
     */
    private boolean[] selected = null;

    /**
     * Message instantiation (form 1).
     * <p>
     * Usages:
     * <ul>
     *     <li>COACH_SET_TEAM_IS_MATCH_END_REPLY</li>
     * </ul>
     *
     * @param type message type
     */
    public Message(int type) {
        this.type = type;
    }

    /**
     * Message instantiation (form 3).
     * <p>
     * Usages:
     * <ul>
     *     <li>COACH_GET_TEAM_STRENGTHS_REPLY</li>
     * </ul>
     *
     * @param type      message type
     * @param strengths the strengths of the team
     */
    public Message(int type, int[] strengths) {
        this.type = type;
        this.strengths = strengths;
    }

    /**
     * Message instantiation (form 4).
     * <p>
     * Usages:
     * <ul>
     *     <li>COACH_SET_TEAM_IS_MATCH_END_REQUEST</li>
     * </ul>
     *
     * @param type       message type
     * @param team       the team
     * @param isMatchEnd the match end flag
     */
    public Message(int type, int team, boolean isMatchEnd) {
        this.type = type;
        this.team = team;
        this.isMatchEnd = isMatchEnd;
    }

    /**
     * Message instantiation (form 5).
     * <p>
     * Usages:
     * <ul>
     *     <li>CONTESTANT_SEAT_DOWN_REQUEST</li>
     * </ul>
     *
     * @param type       message type
     * @param team       the team
     * @param contestant the contestant
     * @param strength   the strength of the contestant
     */
    public Message(int type, int team, int contestant, int strength) {
        this.type = type;
        this.team = team;
        this.contestant = contestant;
        this.strength = strength;
    }

    /**
     * Message instantiation (form 6).
     * <p>
     * Usages:
     * <ul>
     *     <li>CONTESTANT_SEAT_DOWN_REPLY</li>
     * </ul>
     *
     * @param type     message type
     * @param strength the strength of the contestant
     */
    public Message(int type, int strength) {
        this.type = type;
        this.strength = strength;
    }

    /**
     * Get the message type.
     *
     * @return the message type
     */
    public int getType() {
        return type;
    }

    /**
     * Get the team.
     *
     * @return the team
     */
    public int getTeam() {
        return team;
    }

    /**
     * Get the strengths of the team.
     *
     * @return the strengths of the team
     */
    public int[] getStrengths() {
        return strengths;
    }

    /**
     * Get the match end flag.
     *
     * @return the match end flag
     */
    public boolean isMatchEnd() {
        return isMatchEnd;
    }

    /**
     * Get the contestant.
     *
     * @return the contestant
     */
    public int getContestant() {
        return contestant;
    }

    /**
     * Get the strength of the contestant.
     *
     * @return the strength of the contestant
     */
    public int getStrength() {
        return strength;
    }
}