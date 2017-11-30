package tcp_bridge;

import client.Main_page;
import java.io.*;

// This will do any Client Specific actions we decide 
// we need for the bridge
public class Tcp_client_side extends Tcp_bridge 
{

	// Initialize the client
	public void Init()
	{
		if(open_connection("192.168.1.5", 1129))
		{
			// TODO: this should probably be in bridge
			DataOutputStream os = null;
			DataInputStream is = null;
			try
			{
				os = new DataOutputStream(m_socket.getOutputStream());
				is = new DataInputStream(m_socket.getInputStream());
			}
			catch(IOException e)
			{
				System.out.print("io exception on stream open");
				return;
			}
			
			try
			{
				os.writeBytes("Hello World\n");
			}
			catch(IOException e)
			{
				System.out.print("problem sending message");
			}
		}
	}

	// Register a class to receive all the data that comes from the server
	public void Register_reciver(Main_page callback)
	{
		m_callback_class = callback;
	}
	
	// Sends messages to this class with Data_received(Base_data data)
	private Main_page m_callback_class;
}
 