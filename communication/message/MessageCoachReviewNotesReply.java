package communication.message;

/**
 * Internal structure of the coach review notes message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachReviewNotesReply extends Message {
    /**
     * The keep running flag.
     */
    private final boolean keepRunning;

    /**
     * Instantiation of the coach review notes message (reply).
     *
     * @param keepRunning the keep running flag
     */
    public MessageCoachReviewNotesReply(boolean keepRunning) {
        super(MessageType.COACH_REVIEW_NOTES_REPLY);
        this.keepRunning = keepRunning;
    }

    /**
     * Get the keep running flag.
     *
     * @return the keep running flag
     */
    public boolean getKeepRunning() {
        return keepRunning;
    }
}
