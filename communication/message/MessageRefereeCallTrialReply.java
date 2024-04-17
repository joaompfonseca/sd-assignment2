package communication.message;

/**
 * Internal structure of the referee call trial message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeCallTrialReply extends Message {
    /**
     * Instantiation of the referee call trial message (reply).
     */
    public MessageRefereeCallTrialReply() {
        super(MessageType.REFEREE_CALL_TRIAL_REPLY);
    }
}
