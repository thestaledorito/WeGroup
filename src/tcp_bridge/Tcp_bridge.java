package tcp_bridge;

import java.io.*;
import java.net.*;
import java.util.*;

import data_types.Base_data;

// https://www.tutorialspoint.com/java/java_serialization.htm
// how to serialize/ deserialize

public class Tcp_bridge 
{
	public void Init()
	{
		m_incoming_data = new Stack<Base_data>();
		Clear();
	}
	
	// Clear the class data
	public void Clear()
	{
		m_socket = null;
		m_os = null;
		m_is = null;
		m_new_data = false;
		m_incoming_data.clear();
	}
	
	// Close existing connection
	protected boolean close_connection()
	{
		System.out.println("closing connection");
		
		if(m_socket == null)
			return true;
		
		try
		{
			m_socket.close();
			Clear();
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
		
		return open_streams();
	}
	
	// Open the streams for our new connection;
	private boolean open_streams()
	{
		System.out.println("opening streams");
		
		try
		{
			System.out.println("open output stream");
			m_os = new ObjectOutputStream(m_socket.getOutputStream());
			
			m_os.defaultWriteObject();
			m_os.flush();
			
			System.out.println("open input stream");
			m_is = new ObjectInputStream(m_socket.getInputStream());	
			System.out.println("both streams opened");
			return true;
		}
		catch(IOException e)
		{
			System.out.println("io exception on stream open");
			return false;
		}
	}
	
	// Sends a constructed data message
	// Returns whether the message sent
	public boolean Send_data(Base_data data)
	{
		if(!Is_connected())
		{
			System.out.println("socket not connectd");
			return false;
		}
		
		try
		{
			m_os.writeObject(data);
			return true;
		}
		catch(IOException e)
		{
			System.out.println("problem sending message");
			return false;
		}
	}
	
	// returns if we have a active connection
	public boolean Is_connected()
	{
		if(m_socket == null)
			return false;
		
		return m_socket.isConnected();
	}
	
	// Check if we have data
	protected void check_data()
	{
		if(m_new_data)
		{
			synchronized(this)
			{
				while(!m_incoming_data.empty())
				{
					Base_data data = m_incoming_data.pop();
					// TODO: Send data
				}
				m_new_data = false;
			}
		}
	}
	
	// Wrapper around readObject in its own thread
	class receiver implements Runnable
	{
		public void run() {
			m_running = true;
			
			while(m_running)
			{
				Base_data data = null;
				try
				{
					data = (Base_data)m_is.readObject();
				}
				catch(ClassNotFoundException e)
				{
					System.out.println("class not found" + e);
				}
				catch(IOException e)
				{
					System.out.println("IO exception reading object");
				}
				
				if(data != null)
				{
					synchronized(Tcp_bridge.this)
					{
						m_new_data = true;
						m_incoming_data.push(data);
					}
				}
				
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException e)
				{
					m_running = false;
				}
			}
		}
		
		public void Stop()
		{
			m_running = false;
		}
		
		private boolean m_running;
	}
	
	// This will be meaningless for client
	// May not actually need
	protected String m_id;
	
	protected Socket m_socket;
	
	protected ObjectOutputStream m_os;
	
	protected ObjectInputStream m_is;
	
	protected boolean m_new_data;
	
	protected Stack<Base_data> m_incoming_data;
}
