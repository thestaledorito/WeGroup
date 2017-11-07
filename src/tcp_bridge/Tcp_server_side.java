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
		
		m_run = true;
		loop();
	}
	
	private void loop()
	{
		if(m_run)
		{
			check_for_incoming_connection();
			check_clients_alive();
			// Call loop with a timer
			// or just loop?
			// is this going to be event based?
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
	
	private boolean m_run;
	
	private ServerSocket m_server;
	
	private List<Tcp_bridge> m_client_connections;

}
