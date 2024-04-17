package communication.message;

/**
 * Internal structure of the referee set rope position message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeSetRopePositionReply extends Message {
    /**
     * Instantiation of the referee set rope position message (reply).
     */
    public MessageRefereeSetRopePositionReply() {
        super(MessageType.REFEREE_SET_ROPE_POSITION_REPLY);
    }
}
