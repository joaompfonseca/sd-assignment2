package communication.message;

/**
 * Internal structure of the coach review notes message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachReviewNotesRequest extends Message {
    /**
     * The team.
     */
    private final int team;

    /**
     * Instantiation of the coach review notes message (request).
     *
     * @param team the team
     */
    public MessageCoachReviewNotesRequest(int team) {
        super(MessageType.COACH_REVIEW_NOTES_REQUEST);
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
