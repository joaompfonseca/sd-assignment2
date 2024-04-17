package communication.message;

/**
 * Internal structure of the contestant am done message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantAmDoneRequest extends Message {
    /**
     * Instantiation of the contestant am done message (request).
     */
    public MessageContestantAmDoneRequest() {
        super(MessageType.CONTESTANT_AM_DONE_REQUEST);
    }
}
