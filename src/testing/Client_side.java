package testing;

import data_types.*;

public class Client_side
{
	private static Message_data populate_message()
	{
		Message_data mess = new Message_data();
		mess.m_type = Tcp_message_type.Message;
		mess.m_user_id = "no user ID on client side";
		mess.m_recipiants.add("Fred");
		mess.m_recipiants.add("George");
		mess.m_sender = "John";
		mess.m_message = "Hello World";
		mess.m_have_attachment = false;
		mess.m_filename = "file";
		mess.m_file_contents = "";
				
		return mess;
	}
	
	public static void main(String[] args) 
	{
		Client_receiver receiver = new Client_receiver();
		receiver.Init();

		Message_data mess = populate_message();
		System.out.println(mess.toString());
	}

}
