package communication.message;

/**
 * Internal structure of the contestant pull the rope message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantPullTheRopeReply extends Message {
    /**
     * The strength.
     */
    private final int strength;

    /**
     * Instantiation of the contestant pull the rope message (reply).
     *
     * @param strength the strength
     */
    public MessageContestantPullTheRopeReply(int strength) {
        super(MessageType.CONTESTANT_PULL_THE_ROPE_REPLY);
        this.strength = strength;
    }

    /**
     * Get the strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }
}
