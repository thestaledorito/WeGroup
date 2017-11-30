package testing;

import server.Database_manager;
import data_types.*;

public class Server_receiver extends Database_manager 
{

	public void Data_received(Base_data data)
	{
		System.out.println(data.toString());
	}
	
	public void Send_data(Base_data data)
	{
		m_tcp.Send_data(data);
	}
	
}
