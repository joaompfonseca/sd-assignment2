package communication.message;

/**
 * Internal structure of the coach inform referee message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachInformRefereeRequest extends Message {
    /**
     * The team.
     */
    private final int team;

    /**
     * Instantiation of the coach inform referee message (request).
     *
     * @param team the team
     */
    public MessageCoachInformRefereeRequest(int team) {
        super(MessageType.COACH_INFORM_REFEREE_REQUEST);
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
