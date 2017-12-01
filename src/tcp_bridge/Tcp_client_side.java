package tcp_bridge;

import client.Main_page;
import java.io.*;
import data_types.*;

// This will do any Client Specific actions we decide 
// we need for the bridge
public class Tcp_client_side extends Tcp_bridge 
{

	// Initialize the client
	public void Init()
	{
		Clear();
		
		if(open_connection("192.168.1.5", 1129))
		{
			Message_data data = new Message_data();
			data.m_message = "hello world";
			System.out.println(data);
			
			if(!Send_data(data))
			{
				System.out.println("data failed to send");
			}
			
			
			/*// TODO: this should probably be in bridge
			ObjectOutputStream os = null;
			//DataInputStream is = null;
			try
			{
				os = new ObjectOutputStream(m_socket.getOutputStream());
				//is = new DataInputStream(m_socket.getInputStream());
			}
			catch(IOException e)
			{
				System.out.println("io exception on stream open");
				return;
			}
			
			try
			{
				Message_data data = new Message_data();
				data.m_message = "hello world";
				System.out.println(data);
				os.writeObject(data);
				//os.flush();
				//String str = "Test String";
				//os.writeObject(str);
			}
			catch(IOException e)
			{
				System.out.println("problem sending message");
			}*/
		}
		else
		{
			System.out.println("connection failed to open");
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
 