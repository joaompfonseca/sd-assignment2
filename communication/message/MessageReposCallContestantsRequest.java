package communication.message;


public class MessageReposCallContestantsRequest extends Message {

    private final int team;

    public MessageReposCallContestantsRequest(int team) {
        super(MessageType.REPOS_CALL_CONTESTANTS_REQUEST);
        this.team = team;
    }

    public int getTeam() {
        return team;
    }
}
