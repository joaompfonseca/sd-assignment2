package communication.message;

/**
 * Internal structure of the repository assert trial decision message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposAssertTrialDecisionRequest extends Message {

    /**
     * Rope position.
     */
    private final int ropePosition;

    /**
     * Instantiation of the referee assert trial decision message (request).
     *
     * @param ropePosition the rope position
     */
    public MessageReposAssertTrialDecisionRequest(int ropePosition) {
        super(MessageType.REPOS_ASSERT_TRIAL_DECISION_REQUEST);
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
