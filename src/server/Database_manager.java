package server;

import tcp_bridge.Tcp_server_side;

import java.util.List;

import data_types.*;

public class Database_manager 
{
	
	// Initialize this class
	public void Init()
	{
		m_tcp = new Tcp_server_side();
		m_tcp.Init();
		m_tcp.Register_reciver(this);
	}
	
	// Data received from TCP
	public void Data_received(Base_data data)
	{
		
	}
	
	// Class to send TCP
	protected Tcp_server_side m_tcp;
	
	
	
	// Riker's Stuff
	
	public List<Message_server> storedMessages;
	
	/**
	 * Creates a new message type based of the message, target, and if private.  Will be added to stored messages
	 * 		Will be changed if done on client side
	 * @param message	the message to be created
	 * @param target	list of recipients 
	 * @param pvt		tag to check if it is a private message or not
	 */
	public void newMessage(String message, List<String> target, boolean pvt) {
		Message_server msg = new Message_server(message, target, pvt);
		storedMessages.add(msg);
	}
	
	/**
	 * Checks if the message has the user as a recipient
	 * @param messageData	the message being checked
	 * @param user			the user being checked
	 */
	public void updateMessage(Message_server messageData, String user) {
		if(messageData.userAsTarget(user)) {
			messageData.getMessage();
			messageData.isPvt();
			messageData.removeRecip(user);
		}
	}
	
	/**
	 * Removes the message from the stored messages if there are no users left to recieve
	 * @param messageData	the message being checked
	 */
	public void checkMessage(Message_server messageData) {
		if(messageData.recipEmpty()) {
			storedMessages.remove(messageData);
		}
	}
	
	
	
	public void update() {
		
	}
	
	
}
