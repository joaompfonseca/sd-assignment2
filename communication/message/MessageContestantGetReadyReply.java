package communication.message;

/**
 * Internal structure of the contestant get ready message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantGetReadyReply extends Message {
    /**
     * Instantiation of the contestant get ready message (reply).
     */
    public MessageContestantGetReadyReply() {
        super(MessageType.CONTESTANT_GET_READY_REPLY);
    }
}
