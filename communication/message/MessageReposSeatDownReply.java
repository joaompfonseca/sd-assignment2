package communication.message;

/**
 * Internal structure of the repository seat down message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposSeatDownReply extends Message {

    /**
     * Instantiation of the repository seat down message (reply).
     */
    public MessageReposSeatDownReply() {
        super(MessageType.REPOS_SEAT_DOWN_REPLY);
    }
}
