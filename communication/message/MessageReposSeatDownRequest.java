package communication.message;

/**
 * Internal structure of the repository seat down message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposSeatDownRequest extends Message {
    /**
     * The team.
     */
    private final int team;
    /**
     * The contestant.
     */
    private final int contestant;
    /**
     * The strength of the contestant.
     */
    private final boolean increaseStrength;

    /**
     * Instantiation of the repository seat down message (request).
     *
     * @param team       the team
     * @param contestant the contestant
     * @param increaseStrength   the strength of the contestant
     */
    public MessageReposSeatDownRequest(int team, int contestant, boolean increaseStrength) {
        super(MessageType.REPOS_SEAT_DOWN_REQUEST);
        this.team = team;
        this.contestant = contestant;
        this.increaseStrength = increaseStrength;
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
     * Get if increase strength.
     *
     * @return if increase strength of the contestant
     */
    public boolean getStrength() {
        return increaseStrength;
    }
}
