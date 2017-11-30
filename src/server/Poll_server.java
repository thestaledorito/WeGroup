package server;

import java.util.ArrayList;
import java.util.List;

// NEW -RB
// TO DO: 
//		1 - Add a list of users who already voted. Have poll_element keep track of who voted for that element
// 			then if the user votes again, remove the old vote and cast a new vote. 
//		2 - Add a creator role, which that creator can remove elements and the poll.
//		3 - Add a timer for ending poll
//	
public class Poll_server 
{
		
	String poll_id;
	List<Poll_element> poll_contents;
	
	/**
	 * Creates a Poll with a name, and creates an empty content list.
	 * @param name	the id/name/title of the Poll
	 */
	public Poll_server(String name) {
		this.poll_id = name;
		this.poll_contents = new ArrayList<Poll_element>();
	}
	
	/**
	 * Adds an string item into the poll option.
	 * 		Will create a poll element to keep track of votes for the item
	 * @param item	the item being added to the poll
	 */
	public void add_item(String item) {
		Poll_element element = new Poll_element(item);
		this.poll_contents.add(element);
	}
	
	/**
	 * Casts a vote to the item being voted on
	 * @param item	the item a vote is being added to
	 */
	public void add_vote(String item) {
		for(Poll_element element : poll_contents) {
			if(item == element.getItem()) {
				element.addVote();
				break;
			}
		}
	}
	
	
	/**
	 * Gets the id/name/title of the poll
	 * @return	the id/name/title of the poll
	 */
	public String getID() {
		return poll_id;
	}
	
	
	/**
	 * Gets the list of all the elements of the poll. 
	 * @return	the list of poll elements, as poll_element
	 */
	public List<Poll_element> getContent() {
		return poll_contents;
	}

	
}
