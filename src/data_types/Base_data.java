package data_types;


public class Base_data implements java.io.Serializable {

	// Required for Serializable
	// Will probably need for all subclasses
	private static final long serialVersionUID = 1L;
	
	// Type of message that this is
	public Tcp_message_type m_type;

	// Who is this message from/ going too
	// This field is ignored coming from the user
	public String m_user_id;
}
