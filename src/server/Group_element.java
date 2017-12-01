package server;

import java.util.List;

public class Group_element {

	public String groupName;
	public List<String> users;
	
	public List<Poll_server> storedPolls;
	public List<List_server> storedLists;
	
	
	
	public Group_element(String name) {
		this.groupName = name;
	}
	
	
	public void addList(String name) {
		List_server list = new List_server(name);
		storedLists.add(list);
	}
	
	public void addPoll(String name, String userID) {
		if(users.contains(userID)) {
			Poll_server poll = new Poll_server(name, userID);
			storedPolls.add(poll);
		}
	}
	
	
	
	public void addUser(String user) {
		users.add(user);
	}
	
	
	
	public String getGroupName() {
		return groupName;
	}
	
	/*
	public boolean containsUser(String user) {
		if(users.contains(user)) 
			return true;
		else
			return false;
	}*/
	
}
