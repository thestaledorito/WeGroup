package tcp_bridge;

import java.net.*;
import java.io.*;
import java.util.*;

import data_types.Base_data;

//This will do any Client Specific actions we decide 
//we need for the bridge
public class Tcp_server_side {
		
	// Initialize the server
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
		
		m_run = true;
		loop();
	}
	
	// Send a data message
	public void Send_data(Base_data data)
	{
		
	}
	
	private void loop()
	{
		if(m_run)
		{
			check_for_incoming_connection();
			check_clients_alive();
			check_client_messages();
			// Call loop with a timer
			// or just loop?
			// is this going to be event based?
			//    -- probably should be for server messages
		}
	}
	
	
	// Called in a loop to see if server has a new client
	// multiple connections?
	private void check_for_incoming_connection()
	{
		
	}
	
	private void check_clients_alive()
	{
		for(int i = 0; i < m_client_connections.size(); i++)
		{
			if(!m_client_connections.get(i).Is_connected())
			{
				// Close connection
				// delete from list
			}
		}
	}
	
	private void check_client_messages()
	{
		for(int i = 0; i < m_client_connections.size(); i++)
		{
			// Check for messages and pass to server
			// emit a signal?
		}
	}
	
	
	
	
	private boolean m_run;
	
	private ServerSocket m_server;
	
	private List<Tcp_bridge> m_client_connections;

}
