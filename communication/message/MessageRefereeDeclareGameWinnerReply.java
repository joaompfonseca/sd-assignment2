package communication.message;

/**
 * Internal structure of the referee declare game winner message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeDeclareGameWinnerReply extends Message {
    /**
     * Instantiation of the referee declare game winner message (reply).
     */
    public MessageRefereeDeclareGameWinnerReply() {
        super(MessageType.REFEREE_DECLARE_GAME_WINNER_REPLY);
    }
}
