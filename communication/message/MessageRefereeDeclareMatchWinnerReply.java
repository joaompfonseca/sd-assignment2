package communication.message;

/**
 * Internal structure of the referee declare match winner message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeDeclareMatchWinnerReply extends Message {
    /**
     * Instantiation of the referee declare match winner message (reply).
     */
    public MessageRefereeDeclareMatchWinnerReply() {
        super(MessageType.REFEREE_DECLARE_MATCH_WINNER_REPLY);
    }
}
