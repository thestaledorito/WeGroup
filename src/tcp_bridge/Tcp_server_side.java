package tcp_bridge;

import java.net.*;
import java.io.*;
import java.util.*;

import server.Database_manager;

import data_types.*;

// Server side of the TCP connection
// Manages logins
public class Tcp_server_side 
{
		
	// Initialize the server
	public void Init()
	{
		m_login_server = new Login_server();
		m_login_server.Register_server_side(this);
	}
	
	// Register a class to receive all the data that comes from the server
	public void Register_reciver(Database_manager callback)
	{
		m_callback_class = callback;
	}
	
	// Send a data message
	public void Send_data(Base_data data)
	{
		
	}
	
	// Get new login from login server
	public void New_connection(String user_name, String group_name, int port)
	{
		
	}
	
	
	private Login_server m_login_server;
	
	private boolean m_run;
	
	private List<Tcp_server_connection> m_client_connections;

	// Sends messages to this class with Data_received(Base_data data)
	private Database_manager m_callback_class;
}
