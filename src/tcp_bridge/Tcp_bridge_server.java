package tcp_bridge;

import data_types.Base_data;
import java.util.*;
import java.net.*;
import java.io.*;

// This may become abstract as well and pass along
// handeling Distribute_data to children
public class Tcp_bridge_server extends Tcp_bridge 
{
	// Initialize the server bridge
	public void Init()
	{
		super.Init();
		
		m_connected = false;
		m_check_connected_timer = null;
	}
	
	protected void Distribute_data(Base_data data) 
	{
		// TODO Pass up data to send to the server
	}
	
	// Open up port to receive client connection
	public boolean Open_server(int port)
	{
		try
		{
			m_server = new ServerSocket(port);
		}
		catch(IOException e)
		{
			System.out.println("Error creating server:" + e);
			System.out.println(port);
			return false;
		}
		
		return true;
	}
	
	// Starts our timer to check if we are connected
	public void Start_checking_connected()
	{
		if(m_check_connected_timer != null)
			m_check_connected_timer = null;
		
		m_check_connected_timer = new java.util.Timer();
		m_check_connected_timer.schedule
		(
			new java.util.TimerTask()
			{
				public void run()
				{
					check_connected();
				}
			}, 100, 100
		);
	}
	
	// Check if we have accepted a connection
	protected void check_connected()
	{
		if(m_connected)
		{
			m_check_connected_timer = null;
			Start_checking_data();
		}
	}
	
	
	// Wrapper around accept in its own thread
	class receiver implements Runnable
	{
		public void run() 
		{
			m_connected = false;
			
			try
			{
				m_socket = m_server.accept();
			}
			catch(BindException e)
			{
				System.out.println("error binding");
				return;
			}
			catch(IOException e)
			{
				System.out.println("IO error");
				return;
			}
			
			try
			{
				m_is = new ObjectInputStream(m_socket.getInputStream());
				m_os = new ObjectOutputStream(m_socket.getOutputStream());
			}
			catch(IOException e)
			{
				System.out.println("io exception on server stream open");
				return;
			}
			
			m_connected = true;
		}
	}

	protected ServerSocket m_server;
	
	protected Timer m_check_connected_timer;
	
	protected boolean m_connected;
}
