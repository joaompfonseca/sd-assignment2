package communication.message;

/**
 * Internal structure of the shutdown server message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageShutdownReply extends Message {
    /**
     * Instantiation of a shutdown server message (reply).
     */
    public MessageShutdownReply() {
        super(MessageType.SHUTDOWN_REPLY);
    }
}
