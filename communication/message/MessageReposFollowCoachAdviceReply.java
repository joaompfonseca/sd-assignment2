package communication.message;

/**
 * Internal structure of the repository follow coach advice message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposFollowCoachAdviceReply extends Message {

        /**
        * Instantiation of the repository follow coach advice message (reply).
        */
        public MessageReposFollowCoachAdviceReply() {
            super(MessageType.REPOS_FOLLOW_COACH_ADVICE_REPLY);
        }
}
