package communication.message;

/**
 * Internal structure of the repository assert trial decision message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposAssertTrialDecisionReply extends Message{

    /**
     * Instantiation of the repository assert trial decision message (reply).
     */
    public MessageReposAssertTrialDecisionReply() {
        super(MessageType.REPOS_ASSERT_TRIAL_DECISION_REPLY);
    }
}
