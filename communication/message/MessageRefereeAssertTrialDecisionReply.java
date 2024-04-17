package communication.message;

/**
 * Internal structure of the referee assert trial decision message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeAssertTrialDecisionReply extends Message {
    /**
     * The rope position.
     */
    private int ropePosition;

    /**
     * Instantiation of the referee assert trial decision message (reply).
     */
    public MessageRefereeAssertTrialDecisionReply(int ropePosition) {
        super(MessageType.REFEREE_ASSERT_TRIAL_DECISION_REPLY);
        this.ropePosition = ropePosition;
    }

    /**
     * Get the rope position.
     *
     * @return the rope position
     */
    public int getRopePosition() {
        return ropePosition;
    }
}
