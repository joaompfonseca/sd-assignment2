package communication.message;

/**
 * Internal structure of the repository call contestants message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposCallContestantsReply extends Message {

        /**
        * Instantiation of the repository call contestants message (reply).
        */
        public MessageReposCallContestantsReply() {
            super(MessageType.REPOS_CALL_CONTESTANTS_REPLY);
        }
}
