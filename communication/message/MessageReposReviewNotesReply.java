package communication.message;

/**
 * Internal structure of the repository review notes message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposReviewNotesReply extends Message{

    /**
     * Instantiation of the repository review notes message (reply).
     */
    public MessageReposReviewNotesReply() {
        super(MessageType.REPOS_REVIEW_NOTES_REPLY);
    }
}
