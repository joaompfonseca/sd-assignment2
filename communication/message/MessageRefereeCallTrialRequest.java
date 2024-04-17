package communication.message;

/**
 * Internal structure of the referee call trial message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeCallTrialRequest extends Message {
    /**
     * Instantiation of the referee call trial message (request).
     */
    public MessageRefereeCallTrialRequest() {
        super(MessageType.REFEREE_CALL_TRIAL_REQUEST);
    }
}
