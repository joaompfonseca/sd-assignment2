package communication.message;

/**
 * Internal structure of the contestant follow coach advice message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantFollowCoachAdviceReply extends Message {
    /**
     * The keep running flag.
     */
    private final boolean keepRunning;

    /**
     * Instantiation of the contestant follow coach advice message (reply).
     *
     * @param keepRunning the keep running flag
     */
    public MessageContestantFollowCoachAdviceReply(boolean keepRunning) {
        super(MessageType.CONTESTANT_FOLLOW_COACH_ADVICE_REPLY);
        this.keepRunning = keepRunning;
    }

    /**
     * Get the keep running flag.
     *
     * @return the keep running flag
     */
    public boolean getKeepRunning() {
        return keepRunning;
    }
}
