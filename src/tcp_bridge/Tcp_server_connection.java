package tcp_bridge;

import data_types.Base_data;

public class Tcp_server_connection extends Tcp_bridge_server {
	public Tcp_server_connection()
	{
		Init();
	}
	
	// Sets the port number we listen on
	public void Set_port(int port)
	{
		Open_server(port);
		Start_checking_connected();
	}
	
	public void Set_user_info(String user_name, String group_name)
	{
		m_user_name = user_name;
		m_group_name = group_name;
	}
	
	// Send the data up to the server side with the port number
	protected void Distribute_data(Base_data data)
	{
		data.m_user_id = m_user_name;
		data.m_group_id = m_group_name;
		m_server_side.Client_data(data);
	}
	
	protected String m_user_name;
	
	protected String m_group_name;
}
