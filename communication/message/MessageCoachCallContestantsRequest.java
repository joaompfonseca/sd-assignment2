package communication.message;

/**
 * Internal structure of the coach call contestants message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachCallContestantsRequest extends Message {
    /**
     * The team.
     */
    private final int team;
    /**
     * The selected contestants.
     */
    private final boolean[] selected;

    /**
     * Instantiation of the coach call contestants message (request).
     *
     * @param team the team
     */
    public MessageCoachCallContestantsRequest(int team, boolean[] selected) {
        super(MessageType.COACH_CALL_CONTESTANTS_REQUEST);
        this.team = team;
        this.selected = selected;
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
     * Get the selected contestants.
     *
     * @return the selected contestants
     */
    public boolean[] getSelected() {
        return selected;
    }
}
