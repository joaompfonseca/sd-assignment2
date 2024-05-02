package communication.message;

/**
 * Internal structure of the repository call contestants message (request).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageReposCallContestantsRequest extends Message {

    /**
     * Team identifier.
     */
    private final int team;

    /**
     * Instantiation of the repository call contestants message (request).
     *
     * @param team the team identifier
     */
    public MessageReposCallContestantsRequest(int team) {
        super(MessageType.REPOS_CALL_CONTESTANTS_REQUEST);
        this.team = team;
    }

    /**
     * Get the team identifier.
     *
     * @return the team identifier
     */
    public int getTeam() {
        return team;
    }
}
