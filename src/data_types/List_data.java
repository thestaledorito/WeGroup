package data_types;

import java.util.*;

public class List_data extends Base_data 
{
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// What list are we talking about
	public UUID m_list_id;
	
	// What users can see this list
	public List<String> m_users;
	
	// List of items are in the list
	public List<String> m_contents;
}
