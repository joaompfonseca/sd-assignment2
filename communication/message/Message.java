package communication.message;

import java.io.Serial;
import java.io.Serializable;

/**
 * Generic internal structure of the exchanged messages.
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class Message implements Serializable {
    /**
     * Serialization key.
     */
    @Serial
    private static final long serialVersionUID = 2024L;
    /**
     * Message type.
     */
    private final int type;

    /**
     * Message instantiation.
     *
     * @param type message type
     */
    public Message(int type) {
        this.type = type;
    }

    /**
     * Get the message type.
     *
     * @return message type
     */
    public int getType() {
        return type;
    }
}