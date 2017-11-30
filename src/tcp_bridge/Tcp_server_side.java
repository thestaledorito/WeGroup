package tcp_bridge;

import java.net.*;
import java.io.*;
import java.util.*;

import server.Database_manager;

import data_types.Base_data;

//This will do any Client Specific actions we decide 
//we need for the bridge
public class Tcp_server_side 
{
		
	// Initialize the server
	public void Init()
	{
		try
		{
			m_server = new ServerSocket(1129);
		}
		catch(IOException e)
		{
			System.out.println("Error creating server:" + e);
		}
		
		Socket client_socket = null;
		DataInputStream is;
		String line;
		
		try
		{
			client_socket = m_server.accept();
			is = new DataInputStream(client_socket.getInputStream());
			while(true)
			{
				line = is.readLine();
				System.out.print(line);
			}
		}
		catch(IOException e)
		{
			System.out.print("IO error");
		}
		
		//m_run = true;
		//loop();
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

	// Sends messages to this class with Data_received(Base_data data)
	private Database_manager m_callback_class;
}
