package communication.message;

/**
 * Internal structure of the coach inform referee message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachInformRefereeReply extends Message {
    /**
     * Instantiation of the coach inform referee message (reply).
     */
    public MessageCoachInformRefereeReply() {
        super(MessageType.COACH_INFORM_REFEREE_REPLY);
    }
}
