package tcp_bridge;

import java.net.*;
import java.io.*;
import java.util.*;

import server.Database_manager;

import data_types.*;

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
		ObjectOutputStream os;
		ObjectInputStream is;
		Base_data data;
		//String str;
		
		try
		{
			client_socket = m_server.accept();
			
			System.out.println("open input stream");
			is = new ObjectInputStream(client_socket.getInputStream());
			
			System.out.println("open output stream");
			os = new ObjectOutputStream(client_socket.getOutputStream());
			
			//os.defaultWriteObject();
			//os.flush();
			
			System.out.println("both streams opened");
			
			while(true)
			{
				try
				{
					data = (Base_data)is.readObject();
					System.out.println(data);
					Message_data mess = (Message_data)data;
					System.out.println(mess);
					//str = (String)is.readObject();
					//System.out.println(str);
				}
				catch(ClassNotFoundException e)
				{
					System.out.println("class not found" + e);
				}
			}
		}
		catch(BindException e)
		{
			System.out.println("error binding");
		}
		catch(IOException e)
		{
			System.out.println("IO error");
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
	
	// Do we need this?
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
	
	private List<Tcp_server_connection> m_client_connections;

	// Sends messages to this class with Data_received(Base_data data)
	private Database_manager m_callback_class;
}
