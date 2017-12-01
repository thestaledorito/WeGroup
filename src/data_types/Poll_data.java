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
	private static final long serialVersionUID = 41L;
	
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
	
	// Prints out the contents of the poll data
	// TODO Test this
	public String toString()
	{
		String rep = super.toString();
		
		rep += "\n  Poll ID: " + m_poll_id.toString();
		rep += "\n  Creator: " + m_creator;
		rep += "\n  Question: " + m_poll_question;
		rep += "\n  Options:";
		
		Iterator<String> it = m_poll_options.iterator();
		Iterator<Integer> vote_it = m_poll_votes.iterator();
		while(it.hasNext())
		{
			rep += "\n    " + it.next();
			if(vote_it.hasNext())
			{
				rep += " votes: " + vote_it.next();
			}
		}
		
		return rep;
	}
	
	public String getm_Poll_question() {
		return m_poll_question;
	}
	
}
