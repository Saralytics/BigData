package dome;

public class Item {

	private String title;  // classes in child classes, or classes in the same package could visit
	private int playingTime;
	private boolean gotIt = false; // default value set to false
	private String comment;
	
	public Item(String title, int playingTime, boolean gotIt, String comment) {
		super();
		this.title = title;
		this.playingTime = playingTime;
		this.gotIt = gotIt;
		this.comment = comment;
	}
	
	public void print() {
		System.out.println(title);
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
