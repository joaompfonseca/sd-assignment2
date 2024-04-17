package communication.message;

/**
 * Internal structure of the referee declare game winner message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeDeclareGameWinnerRequest extends Message {
    /**
     * The team.
     */
    private final int team;
    /**
     * The knockout flag.
     */
    private final boolean knockout;

    /**
     * Instantiation of the referee declare game winner message (request).
     *
     * @param team     the team
     * @param knockout the knockout flag
     */
    public MessageRefereeDeclareGameWinnerRequest(int team, boolean knockout) {
        super(MessageType.REFEREE_DECLARE_GAME_WINNER_REQUEST);
        this.team = team;
        this.knockout = knockout;
    }

    /**
     * Get the team.
     *
     * @return the team
     */
    public int getTeam() {
        return team;
    }

    /**
     * Get the knockout flag.
     *
     * @return the knockout flag
     */
    public boolean isKnockout() {
        return knockout;
    }
}
