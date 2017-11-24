package server;

// NEW -RB
public class Poll_element {

	String item;
	int votes;
	
	public Poll_element(String name) {
		this.item = name;
		this.votes = 0;
	}
	
	public String getItem() {
		return item;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public void addVote() {
		votes++;
	}
	
}
