package communication.message;

/**
 * Internal structure of the referee start trial message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeStartTrialReply extends Message {
    /**
     * Instantiation of the referee start trial message (reply).
     */
    public MessageRefereeStartTrialReply() {
        super(MessageType.REFEREE_START_TRIAL_REPLY);
    }
}
