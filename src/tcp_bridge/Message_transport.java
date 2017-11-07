package tcp_bridge;

public class Message_transport extends Transport_base {
	
	public void Serialize_file(String filename)
	{
		// trim filename and assing to m_filename
		
		// read byte contents of the file and assign to m_file_contents
		
		// If we are sucsessful set m_have_attachement = true;
	}
	
	public void Deserialize_file(String path)
	{
		// create file with m_filename at path
		
		// copy bytes from m_file_contents into file
	}
	
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
}
