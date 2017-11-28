package data_types;

import java.util.*;

public class List_data extends Base_data 
{
	// Default constructor
	public List_data()
	{
		super();
		m_type = Tcp_message_type.List;
		
		m_list_id = new UUID(0,0);
		m_users = new Vector<String>();
		m_contents = new Vector<String>();
	}
	
	// Required for Serializable
	private static final long serialVersionUID = 31L;
	
	// What list are we talking about
	public UUID m_list_id;
	
	// What users can see this list
	public List<String> m_users;
	
	// List of items are in the list
	public List<String> m_contents;

	// Prints out the contents of the list
	// TODO Test this
	public String toString()
	{
		String rep = super.toString();
		
		rep += "\n  List ID: " + m_list_id.toString();
		rep += "\n  List users:";
		
		Iterator<String> it = m_users.iterator();
		while(it.hasNext())
		{
			rep += "\n    " + it.next();
		}
		
		rep += "\n  List contents:";
		
		it = m_contents.iterator();
		while(it.hasNext())
		{
			rep += "\n    " + it.next();
		}
	
		return rep;
	}
}
