package communication.message;

/**
 * Internal structure of the referee set rope position message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeSetRopePositionRequest extends Message {
    /**
     * The rope position.
     */
    private final int ropePosition;

    /**
     * Instantiation of the referee set rope position message (request).
     *
     * @param ropePosition the rope position
     */
    public MessageRefereeSetRopePositionRequest(int ropePosition) {
        super(MessageType.REFEREE_SET_ROPE_POSITION_REQUEST);
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
