package server;

import java.util.List;

public class Message_server 
{

	//String msg_id;
	String message;
	List<String> recipients;
	boolean pvt;
	
	/**
	 * 
	 * @param msg 	the message to be sent
	 * @param target	the recipients for the message. if 1 user, send in a list still
	 * @param pvt	privateMessage flag. If True, the message is intended for that 1 user.
	 */
	public Message_server(String msg, List<String> target, Boolean pvt) {
		this.message = msg;
	}
	
	/**
	 * Checks if the message is private or not
	 * @return	True if the message is private
	 */
	public boolean isPvt() {
		return pvt;
	}
		
}
