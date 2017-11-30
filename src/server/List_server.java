package server;

import java.util.ArrayList;
import java.util.List;

// NEW -RB
// TO DO:
// 		1 - Add a list of users who can interact with the list
public class List_server 
{
	String list_id; 
	List<String> list_contents;
	
	// Creates an empty list, with a name
	public List_server(String name) {
		this.list_id = name;
		this.list_contents = new ArrayList<String>();
	}
	
	// Adds an item into the list
	public void add_item(String item) {
		list_contents.add(item);
	}
	
	// Removes an item from the list
	public void remove_item(String item) {
		int index = 0;
		for(String element : list_contents) {
			if(item == element){
				break;
			}
			index++;
		}
		if(index < list_contents.size())
			list_contents.remove(index);
	}
	
	// Returns the name/id for the list
	public String getID() {
		return list_id;
	}
	
	// Returns a list of Strings
	// Each string is an element on the list.
	public List<String> getContent() {
		return list_contents;
	}
	
	
	
}
