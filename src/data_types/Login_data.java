package data_types;

// Login needs to take a different path and message structure than everything else

public class Login_data extends Base_data {
	String m_user_name;
	
	// Do we need to bother hashing?
	String m_password;
}
