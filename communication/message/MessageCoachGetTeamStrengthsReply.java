package communication.message;

/**
 * Internal structure of the coach get team strengths message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachGetTeamStrengthsReply extends Message {
    /**
     * The strengths of the team.
     */
    private final int[] strengths;

    /**
     * Instantiation of the coach get team strengths message (reply).
     *
     * @param strengths the strengths of the team
     */
    public MessageCoachGetTeamStrengthsReply(int[] strengths) {
        super(MessageType.COACH_GET_TEAM_STRENGTHS_REPLY);
        this.strengths = strengths;
    }

    /**
     * Get the strengths of the team.
     *
     * @return the strengths of the team
     */
    public int[] getStrengths() {
        return strengths;
    }
}
