package communication.message;

/**
 * Internal structure of the referee declare match winner message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageRefereeDeclareMatchWinnerRequest extends Message {
    /**
     * The team.
     */
    private final int team;

    /**
     * Instantiation of the referee declare match winner message (request).
     *
     * @param team the team
     */
    public MessageRefereeDeclareMatchWinnerRequest(int team) {
        super(MessageType.REFEREE_DECLARE_MATCH_WINNER_REQUEST);
        this.team = team;
    }

    /**
     * Get the team.
     *
     * @return the team
     */
    public int getTeam() {
        return team;
    }
}
