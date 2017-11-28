package data_types;

import java.util.*;

public class Poll_data extends Base_data 
{
	// Default constructor
	public Poll_data()
	{
		super();
		m_type = Tcp_message_type.Poll;
		
		m_poll_id = new UUID(0,0);
		m_creator = "";
		m_poll_question = "";
		m_poll_options = new Vector<String>();
		m_poll_votes = new Vector<Integer>();
	}
	
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
	
	// TODO toString
}
