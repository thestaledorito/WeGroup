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
	
	public Poll_server(String name) {
		this.poll_id = name;
		this.poll_contents = new ArrayList<Poll_element>();
	}
	
	public void add_item(String item) {
		Poll_element element = new Poll_element(item);
		this.poll_contents.add(element);
	}
	
	public void add_vote(String item) {
		for(Poll_element element : poll_contents) {
			if(item == element.getItem()) {
				element.addVote();
				break;
			}
		}
	}

	
}
