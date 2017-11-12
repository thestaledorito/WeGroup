package client;

import data_types.*;
import tcp_bridge.Tcp_client_side;

public class Main_page {

	// Initialize this class
	public void Init()
	{
		m_tcp = new Tcp_client_side();
		m_tcp.Init();
		m_tcp.Register_reciver(this);
	}
	
	// Data received from TCP
	public void Data_received(Base_data data)
	{
		
	}
	
	// Class to send TCP
	private Tcp_client_side m_tcp;
}
