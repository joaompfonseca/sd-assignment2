package communication.message;

/**
 * Internal structure of the contestant seat down message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageContestantSeatDownReply extends Message {
    /**
     * The strength of the contestant.
     */
    private final int strength;

    /**
     * Instantiation of the contestant seat down message (reply).
     *
     * @param strength   the strength of the contestant
     */
    public MessageContestantSeatDownReply(int strength) {
        super(MessageType.CONTESTANT_SEAT_DOWN_REPLY);
        this.strength = strength;
    }

    /**
     * Get the strength of the contestant.
     *
     * @return the strength of the contestant
     */
    public int getStrength() {
        return strength;
    }
}
