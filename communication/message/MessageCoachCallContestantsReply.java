package communication.message;

/**
 * Internal structure of the coach call contestants message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachCallContestantsReply extends Message {
    /**
     * Instantiation of the coach call contestants message (reply).
     */
    public MessageCoachCallContestantsReply() {
        super(MessageType.COACH_CALL_CONTESTANTS_REPLY);
    }
}
