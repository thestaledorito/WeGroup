package tcp_bridge;

import java.util.*;

public class Login_server extends Tcp_bridge_server 
{
	public Login_server()
	{
		m_users = new ArrayList<User_login>();
	}
	
	// TODO: Need to worry about all the port stuff to deal
	// with establishing a protocol for login and transferring
	// a connection to the regular connection on a new port
	
	// Add a new user with the user, group and password
	// Will fail if any of the fields are empty or if
	// we already have that user
	public void Add_user(String user_name, String group_name, String password)
	{
		if(user_name != "" && group_name != "" && password != "" &&
				!Contains_user(user_name, group_name))
		{
			User_login new_user = new User_login();
			new_user.m_user_name = user_name;
			new_user.m_group_name = group_name;
			new_user.m_password = password;
			
			m_users.add(new_user);
		}
	}
	
	// Do we have that user
	public boolean Contains_user(String user_name, String group_name)
	{
		User_login user = find_user(user_name, group_name);
		if(user.m_user_name == "" || user.m_group_name == "")
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	// is the login valid for the user
	public boolean Valid_login(String user_name, String group_name, String password)
	{
		User_login user = find_user(user_name, group_name);
		if(user.m_password != "" && password == user.m_password)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Returns the user with the user and group name
	// Returns default User_login (empty strings) on failure
	private User_login find_user(String user_name, String group_name)
	{
		// iterate through and find a user
		// return empty string on failure
		return new User_login();
	}
	
	private List<User_login> m_users;
}
