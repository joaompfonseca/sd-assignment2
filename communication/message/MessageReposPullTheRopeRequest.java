package communication.message;

/**
 * Internal structure of the repository pull the rope message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposPullTheRopeRequest extends Message {

    /**
     * The team.
     */
    private final int team;
    /**
     * The contestant.
     */
    private final int contestant;
    /**
     * Reduce.
     */
    private final boolean reduce;

    /**
     * Instantiation of the contestant pull the rope message (request).
     *
     * @param team       the team
     * @param contestant the contestant
     * @param reduce     reduce
     */
    public MessageReposPullTheRopeRequest(int team, int contestant, boolean reduce) {
        super(MessageType.REPOS_PULL_THE_ROPE_REQUEST);
        this.team = team;
        this.contestant = contestant;
        this.reduce = reduce;
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
     * Get if it has to reduce.
     *
     * @return reduce
     */
    public boolean getReduce() {
        return reduce;
    }

}
