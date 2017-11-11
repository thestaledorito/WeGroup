package data_types;

// Login needs to take a different path and message structure than everything else

public class Login_data extends Base_data {
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// Name of the user
	public String m_user_name;
	
	// What group are they in
	public String m_group_name;
	
	// Password that the user needs
	// Do we need to bother hashing?
	public String m_password;
}
