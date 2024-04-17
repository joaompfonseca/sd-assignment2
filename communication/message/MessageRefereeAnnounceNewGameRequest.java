package communication.message;

/**
 * Internal structure of the referee announce new game message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeAnnounceNewGameRequest extends Message {
    /**
     * Instantiation of the referee announce new game message (request).
     */
    public MessageRefereeAnnounceNewGameRequest() {
        super(MessageType.REFEREE_ANNOUNCE_NEW_GAME_REQUEST);
    }
}
