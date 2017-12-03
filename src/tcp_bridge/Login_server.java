package tcp_bridge;

import java.util.*;

public class Login_server extends Tcp_bridge_server 
{
	public Login_server()
	{
		m_users = new ArrayList<User_login>();
	}
	
	public void Add_user(String user_name, String group_name, String password)
	{
		if(!Contains_user(user_name, group_name))
		{
			User_login new_user = new User_login();
			new_user.m_user_name = user_name;
			new_user.m_group_name = group_name;
			new_user.m_password = password;
			
			m_users.add(new_user);
		}
	}
	
	public boolean Contains_user(String user_name, String group_name)
	{
		// Iterated through m_users
		// If we have a match of user and group name true
		// Otherwise false
		
		return false;
	}
	
	public boolean Valid_login(String user_name, String group_name, String password)
	{
		return true;
	}
	
	// private iterator function for above 2?
	
	private List<User_login> m_users;
}
