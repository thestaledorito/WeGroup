package tcp_bridge;

import java.io.*;
import java.net.*;
import java.util.*;

import data_types.Base_data;

// https://www.tutorialspoint.com/java/java_serialization.htm
// how to serialize/ deserialize

public class Tcp_bridge 
{
	// Close existing connection
	protected boolean close_connection()
	{
		if(m_socket == null)
			return true;
		
		try
		{
			m_socket.close();
			return true;
		}
		catch(IOException e)
		{
			System.out.println("IO exception closing connection");
			return false;
		}
	}
	
	// Open a new connection
	protected boolean open_connection(String host, int port)
	{
		if(m_socket == null)
		{
			if(!close_connection())
				return false;
		}
		
		try
		{
			m_socket = new Socket(host, port);
			return true;
		}
		catch(UnknownHostException e)
		{
			System.out.print("bad host name ");
			System.out.println(host);
			return false;
		}
		catch(IOException e)
		{
			System.out.println("couldn't get I/O connection for:");
			System.out.println(host);
			System.out.println(port);
			return false;
		}
	}
	
	// Sends a constructed data message
	public void Send_data(Base_data data)
	{
		String message = serialize(data);
		
		// Check if connected
		// Looks like we need to use streams
		// use m_socket to send
	}
	
	// returns if we have a active connection
	public boolean Is_connected()
	{
		if(m_socket == null)
			return false;
		
		return m_socket.isConnected();
	}
	
	// Takes in a data class and returns it serialized
	private String serialize(Base_data data)
	{
		
		return "serialized output";
	}
	
	// Takes in a serialized data class and returns the corresponding type
	private Base_data deserialize(String data)
	{
		Base_data deserialized_data = null;
		return deserialized_data;
	}
	
	
	// TODO: have a runnable that does readObject
	// When we get a object use synchronized (or a
	// mutex) to lock when writing the data (pushing
	// onto the stack. Flag when we have new data. 
	// Loop and when we see new data we pop off all
	// items on the stack and pass them along.
	
	// TBD if we will need to have a new class for 
	// readObject or if it can be a has as relationship.
	// If it needs to be its own separate class then
	// we will need to share m_os, m_new_data, and
	// m_incoming_data
	
	
	// This will be meaningless for client
	// May not actually need
	protected String m_id;
	
	protected Socket m_socket;
	
	protected ObjectOutputStream m_os;
	
	protected ObjectInputStream m_is;
	
	protected boolean m_new_data;
	
	protected Stack<Base_data> m_incoming_data;
}
