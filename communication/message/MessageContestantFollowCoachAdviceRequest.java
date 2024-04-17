package communication.message;

/**
 * Internal structure of the contestant follow coach advice message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantFollowCoachAdviceRequest extends Message {
    /**
     * The team.
     */
    private final int team;
    /**
     * The contestant.
     */
    private final int contestant;

    /**
     * Instantiation of the contestant follow coach advice message (request).
     *
     * @param team       the team
     * @param contestant the contestant
     */
    public MessageContestantFollowCoachAdviceRequest(int team, int contestant) {
        super(MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REQUEST);
        this.team = team;
        this.contestant = contestant;
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
}
