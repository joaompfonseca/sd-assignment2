package communication.message;

/**
 * Internal structure of the contestant am done message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantAmDoneReply extends Message {
    /**
     * Instantiation of the contestant am done message (reply).
     */
    public MessageContestantAmDoneReply() {
        super(MessageType.CONTESTANT_AM_DONE_REPLY);
    }
}
