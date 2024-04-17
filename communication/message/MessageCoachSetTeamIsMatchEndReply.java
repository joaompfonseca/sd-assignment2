package communication.message;

/**
 * Internal structure of the coach set team is match end message (reply).
 *
 * @author Diogo Paiva (103183)
 * @author João Fonseca (103154)
 * @version 1.0
 */
public class MessageCoachSetTeamIsMatchEndReply extends Message {
    /**
     * Instantiation of the coach set team is match end message (reply).
     */
    public MessageCoachSetTeamIsMatchEndReply() {
        super(MessageType.COACH_SET_TEAM_IS_MATCH_END_REPLY);
    }
}
