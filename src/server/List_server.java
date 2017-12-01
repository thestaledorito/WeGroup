package server;

import java.util.ArrayList;
import java.util.List;

// NEW -RB
// TO DO:
// 		1 - Add a list of users who can interact with the list -Done by Trevor
public class List_server 
{
	String list_id; 
	List<String> list_contents;
	List<String> list_users;
	
	
	/**
	 * Creates an empty list with a name
	 * @param name	the id/name/title of the list
	 */
	public List_server(String name) {
		this.list_id = name;
		this.list_contents = new ArrayList<String>();
		this.list_users = new ArrayList<String>();
	}
	
	
	/**
	 * Adds an item onto the list
	 * @param item	the item to be added on the list
	 */
	public void add_item(String item) {
		list_contents.add(item);
	}
	
	
	/**
	 * removes an item from the list
	 * @param item	the item being removed
	 */
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
	
	
	/**
	 * gets the name of the list
	 * @return	the id/name/title of the list
	 */
	public String getID() {
		return list_id;
	}
	

	/**
	 * gets the elements in the list
	 * @return	a list of all the elements on the list.
	 */
	public List<String> getContent() {
		return list_contents;
	}
	
	public void add_user(String name) {
		list_users.add(name);
	}
	
}
