package data_types;

import java.util.*;

public class Poll_vote_data extends Base_data 
{
	// Default constructor
	public Poll_vote_data()
	{
		super();
		m_type = Tcp_message_type.Poll_vote;
		
		m_poll_id = new UUID(0,0);
		m_vote = -1;
	}
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// ID of the poll
	public UUID m_poll_id;
	
	// What poll option the user wants
	public int m_vote;
	
	// TODO toString
}
