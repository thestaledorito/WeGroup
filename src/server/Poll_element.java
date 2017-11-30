package server;

// NEW -RB
public class Poll_element {

	String item;
	int votes;
	
	/**
	 * Creates a new poll element with a name
	 * @param name	the name/item to vote on
	 */
	public Poll_element(String name) {
		this.item = name;
		this.votes = 0;
	}
	
	/**
	 * gets the item name
	 * @return	the item name
	 */
	public String getItem() {
		return item;
	}
	
	/**
	 * gets the number of votes
	 * @return	the number of votes for the item
	 */
	public int getVotes() {
		return votes;
	}
	
	/**
	 * Adds a vote to the item
	 */
	public void addVote() {
		votes++;
	}
	public void removeVote(){
		votes--;
	}
	
}
