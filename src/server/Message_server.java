package server;

import java.util.List;

public class Message_server 
{

	//String msg_id;
	String message;
	List<String> recipients;
	boolean pvt;
	
	/**
	 * Creates a message, with recipients and a flag for checking if private
	 * @param msg 	the message to be sent
	 * @param target	the recipients for the message. if 1 user, send in a list still
	 * @param pvt	privateMessage flag. If True, the message is intended for that 1 user.
	 */
	public Message_server(String msg, List<String> target, Boolean pvt) {
		this.message = msg;
		this.recipients = target;
		this.pvt = pvt;
	}
	
	/**
	 * Checks if the message is private or not
	 * @return	True if the message is private
	 */
	public boolean isPvt() {
		return pvt;
	}
	
	public void removeRecip(String target) {
		recipients.remove(target);
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean userAsTarget(String user) {
		if(recipients.contains(user))
			return true;
		else
			return false;
	}
	
	
}
