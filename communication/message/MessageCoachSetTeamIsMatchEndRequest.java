package communication.message;

/**
 * Internal structure of the coach set team is match end message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachSetTeamIsMatchEndRequest extends Message {
    /**
     * The team.
     */
    private final int team;
    /**
     * The match end flag.
     */
    private final boolean isMatchEnd;

    /**
     * Instantiation of the coach set team is match end message (request).
     *
     * @param team the team
     */
    public MessageCoachSetTeamIsMatchEndRequest(int team, boolean isMatchEnd) {
        super(MessageType.COACH_SET_TEAM_IS_MATCH_END_REQUEST);
        this.team = team;
        this.isMatchEnd = isMatchEnd;
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
     * Get the match end flag.
     *
     * @return the match end flag
     */
    public boolean getIsMatchEnd() {
        return isMatchEnd;
    }
}
