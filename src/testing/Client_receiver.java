package testing;

import client.Main_page;
import data_types.*;

public class Client_receiver extends Main_page 
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
