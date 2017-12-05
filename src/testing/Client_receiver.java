package testing;

import client.Login;
import data_types.*;

public class Client_receiver extends Login
{
	
	public void Data_received(Base_data data)
	{
		System.out.println("data has made it to client");
		System.out.println(data.toString());
	}
	
	public void Send_data(Base_data data)
	{
		System.out.println("client sending data");
		System.out.println(data);
		m_tcp.Send_data(data);
	}

}
