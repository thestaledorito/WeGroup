package tcp_bridge;

import java.net.*;
import java.io.*;
import java.util.*;

//This will do any Client Specific actions we decide 
//we need for the bridge
public class Tcp_server_side {
		
	public void Init()
	{
		try
		{
			m_server = new ServerSocket(6969);
		}
		catch(IOException e)
		{
			System.out.println("Error creating server:" + e);
		}
	}
	
	// Called in a loop to see if server has a new client
	private void check_for_incoming_connection()
	{
		
	}
	
	private void check_clients_alive()
	{
		
	}
	
	private ServerSocket m_server;
	
	private List<Tcp_bridge> m_client_connections;

}
