package data_types;

import java.util.*;

public class Add_group_data extends Base_data 
{
	public Add_group_data()
	{
		super();
		m_type = Tcp_message_type.Add_group;
		
		m_group_name = "";
		m_user_names = new Vector<String>();
		m_passwords = new Vector<String>();
	}
	
	// Required for Serializable
	private static final long serialVersionUID = 100L;
	
	// Name of the group
	public String m_group_name;
	
	// Users in the group
	public List<String> m_user_names;
	
	// Passwords for the users
	public List<String> m_passwords;
	
	// Prints out the contents of the add group data
	// TODO Test this
	public String toString()
	{
		String rep = super.toString();
		
		rep += "\n  group name: " + m_group_name;

		Iterator<String> it = m_user_names.iterator();
		Iterator<String> pas_it = m_passwords.iterator();
		while(it.hasNext())
		{
			rep += "\n    " + it.next();
			if(pas_it.hasNext())
			{
				rep += " password: " + pas_it.next();
			}
		}
		
		return rep;
	}
}
