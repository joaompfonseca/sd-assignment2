package communication.message;

/**
 * Internal structure of the referee assert trial decision message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeAssertTrialDecisionRequest extends Message {
    /**
     * Instantiation of the referee assert trial decision message (request).
     */
    public MessageRefereeAssertTrialDecisionRequest() {
        super(MessageType.REFEREE_ASSERT_TRIAL_DECISION_REQUEST);
    }
}
