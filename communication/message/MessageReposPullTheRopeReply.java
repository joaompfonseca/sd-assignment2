package communication.message;

/**
 * Internal structure of the repository pull the rope message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposPullTheRopeReply extends Message {

    /**
     * Instantiation of the repository pull the rope message (reply).
     */
    public MessageReposPullTheRopeReply() {
        super(MessageType.REPOS_PULL_THE_ROPE_REPLY);
    }
}
