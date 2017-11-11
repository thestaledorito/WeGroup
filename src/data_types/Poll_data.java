package data_types;

import java.util.*;

public class Poll_data extends Base_data {
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// ID of the poll
	public UUID m_poll_id;
	
	// Who created this poll
	// UI can ignore this
	public transient String m_creator;
	
	// Question the poll is asking
	public String m_poll_question;
	
	// List of answers that the poll contains
	public List<String> m_poll_options;
}
