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
	
	
// LIST STUFF
	public void addList(String name) {
		List_server list = new List_server(name);
		storedLists.add(list);
	}
	
	public boolean listExists(String name) {
		for(List_server list : storedLists) {
			if(list.getID() == name) {
				return true;
			}
		}
		return false;
	}
	
	public List_server getList(String name) {
		for(List_server list : storedLists) {
			if(list.getID() == name) {
				return list;
			}
		}
		return null;
	}
	
// POLL STUFF
	public void addPoll(String name, String userID) {
		if(users.contains(userID)) {
			Poll_server poll = new Poll_server(name, userID);
			storedPolls.add(poll);
		}
	}
	
	
	public boolean pollExists(String name) {
		for(Poll_server poll : storedPolls) {
			if (poll.getID() == name) {
				return true;
			}
		}
		return false;
	}
	
	public Poll_server getPoll(String name) {
		for(Poll_server poll : storedPolls) {
			if (poll.getID() == name) {
				return poll;
			}
		}
		return null;
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
