package communication.message;

/**
 * Internal structure of the shutdown server message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageShutdownRequest extends Message {
    /**
     * Instantiation of a shutdown server message (request).
     */
    public MessageShutdownRequest() {
        super(MessageType.SHUTDOWN_REQUEST);
    }
}
