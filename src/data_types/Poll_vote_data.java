package data_types;

import java.util.*;

public class Poll_vote_data extends Base_data {
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// ID of the poll
	public UUID m_poll_id;
	
	// What poll option the user wants
	public int m_vote;
}
