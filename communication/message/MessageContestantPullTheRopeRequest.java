package communication.message;

/**
 * Internal structure of the contestant pull the rope message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantPullTheRopeRequest extends Message {
    /**
     * The team.
     */
    private final int team;
    /**
     * The contestant.
     */
    private final int contestant;
    /**
     * The strength.
     */
    private final int strength;

    /**
     * Instantiation of the contestant pull the rope message (request).
     *
     * @param team       the team
     * @param contestant the contestant
     * @param strength   the strength
     */
    public MessageContestantPullTheRopeRequest(int team, int contestant, int strength) {
        super(MessageType.CONTESTANT_PULL_THE_ROPE_REQUEST);
        this.team = team;
        this.contestant = contestant;
        this.strength = strength;
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
     * Get the contestant.
     *
     * @return the contestant
     */
    public int getContestant() {
        return contestant;
    }

    /**
     * Get the strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }
}
