package tcp_bridge;

import client.Main_page;;

// This will do any Client Specific actions we decide 
// we need for the bridge
public class Tcp_client_side extends Tcp_bridge {

	// Initialize the client
	public void Init()
	{
		
	}

	// Register a class to receive all the data that comes from the server
	public void Register_reciver(Main_page callback)
	{
		m_callback_class = callback;
	}
	
	// Sends messages to this class with Data_received(Base_data data)
	private Main_page m_callback_class;
}
 