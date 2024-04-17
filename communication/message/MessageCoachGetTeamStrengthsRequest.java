package communication.message;

/**
 * Internal structure of the coach get team strengths message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachGetTeamStrengthsRequest extends Message {
    /**
     * The team.
     */
    private final int team;

    /**
     * Instantiation of the coach get team strengths message (request).
     *
     * @param team the team
     */
    public MessageCoachGetTeamStrengthsRequest(int team) {
        super(MessageType.COACH_GET_TEAM_STRENGTHS_REQUEST);
        this.team = team;
    }

    /**
     * Get the team.
     *
     * @return the team
     */
    public int getTeam() {
        return team;
    }
}
