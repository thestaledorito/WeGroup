package tcp_bridge;

import java.io.*;
import java.net.*;

import data_types.Base_data;

// https://www.tutorialspoint.com/java/java_serialization.htm
// how to serialize/ deserialize

public class Tcp_bridge 
{
	
	// Sends a constructed data message
	public void Send_data(Base_data data)
	{
		String message = serialize(data);
		
		// use m_socket to send
	}
	
	// returns if we have a active connection
	public boolean Is_connected()
	{
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
	
	
	protected Socket m_socket;
}
