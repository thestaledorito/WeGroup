package data_types;

import java.util.*;

public class Poll_data extends Base_data {
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// ID of the poll
	public UUID m_poll_id;
	
	// Who created this poll
	public String m_creator;
	
	// Question the poll is asking
	public String m_poll_question;
	
	// List of answers that the poll contains
	public List<String> m_poll_options;
	
	// List of the current poll votes
	public List<Integer> m_poll_votes;
}
