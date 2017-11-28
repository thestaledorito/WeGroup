package data_types;

import java.util.*;


public class Message_data extends Base_data 
{
	// Default constructor
	public Message_data()
	{
		super();
		m_type = Tcp_message_type.Message;
		
		m_recipiants = new Vector<String>();
		m_sender = "";
		m_message = "";
		m_have_attachment = false;
		m_filename = "";
		m_file_contents = "";
	}
	
	// Required for Serializable
	private static final long serialVersionUID = 1L;
	
	// Who is receiving this message
	public List<String> m_recipiants;
	
	// Who sent the message in question
	public String m_sender;
	
	// Message contents. Will be formatted in UTF8 to allow for emoji
	// Simple formatting will be handled by using HTML tags in the string
	// https://stackoverflow.com/questions/4769076/how-to-make-font-bold-in-java-dialogue-box
	public String m_message;
	
	// do we have a attachment
	public boolean m_have_attachment;
	
	// Filename for attached file
	public String m_filename;
	
	// String version of a attached file
	// Want a byte array here. Not sure the Java class
	public String m_file_contents;
	
	
	// This should probably go into UI
	public void Serialize_file(String filename)
	{
		// trim filename and assign to m_filename
		// read byte contents of the file and assign to m_file_contents
		// If we are successful set m_have_attachement = true;
	}
	
	// This should probably go into the UI
	public void Deserialize_file(String path)
	{
		// create file with m_filename at path
		// copy bytes from m_file_contents into file
	}
	
	// Prints out the contents of the message
	public String toString()
	{
		String rep = super.toString();
		
		rep += ":\n  To:";
		
		Iterator<String> it = m_recipiants.iterator();
		while(it.hasNext())
		{
			rep += "\n    " + it.next();
		}
		
		rep += "\n  From: " + m_sender;
		rep += "\n  Message: " + m_message;
		
		if(m_have_attachment)
		{
			rep += "\n  Attachment: " + m_filename;
			// Do we want contents?
		}

		return rep;
	}
}
