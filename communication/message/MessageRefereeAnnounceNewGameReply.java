package communication.message;

/**
 * Internal structure of the referee announce new game message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeAnnounceNewGameReply extends Message {
    /**
     * Instantiation of the referee announce new game message (reply).
     */
    public MessageRefereeAnnounceNewGameReply() {
        super(MessageType.REFEREE_ANNOUNCE_NEW_GAME_REPLY);
    }
}
