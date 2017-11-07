package tcp_bridge;

import java.io.*;
import java.net.*;

// https://www.tutorialspoint.com/java/java_serialization.htm
// how to serialize/ deserialize

public class Tcp_bridge {
	
	// Sends a constructed data message
	public void Send_data(Transport_base data)
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
	private String serialize(Transport_base data)
	{
		
		return "serialized output";
	}
	
	// Takes in a serialized data class and returns the corresponding type
	private Transport_base deserialize(String data)
	{
		Transport_base deserialized_data = null;
		return deserialized_data;
	}
	
	
	protected Socket m_socket;
}
