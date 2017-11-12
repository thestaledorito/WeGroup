package server;

import tcp_bridge.Tcp_server_side;
import data_types.*;

public class Database_manager {
	
	// Initialize this class
	public void Init()
	{
		m_tcp = new Tcp_server_side();
		m_tcp.Init();
		m_tcp.Register_reciver(this);
	}
	
	// Data received from TCP
	public void Data_received(Base_data data)
	{
		
	}

	// Class to send TCP
	private Tcp_server_side m_tcp;
}
