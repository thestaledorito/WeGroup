package data_types;


public class Base_data implements java.io.Serializable 
{
	// Default constructor
	public Base_data()
	{
		m_type = Tcp_message_type.Other;
		m_user_id = "";
	}

	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// Type of message that this is
	public Tcp_message_type m_type;

	// Who is this message from/ going too
	// This field is used to communicate with the server
	// UI can ignore this field
	public transient String m_user_id;
}
