package communication.message;

/**
 * Internal structure of the referee start trial message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeStartTrialRequest extends Message {
    /**
     * Instantiation of the referee start trial message (request).
     */
    public MessageRefereeStartTrialRequest() {
        super(MessageType.REFEREE_START_TRIAL_REQUEST);
    }
}
