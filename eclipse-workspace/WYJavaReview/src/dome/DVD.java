package dome;

public class DVD extends Item {
	
	private String director;
	
	// Create constructor for DVD
	
	public DVD(String title, String director, int playingTime, String comment) {
		super(title, playingTime, false, comment);
		setTitle("reset title");
		this.director = director;
	}
	
	public void print() {
		System.out.print("DVD: "+ director+ " ");
		super.print();
		
	}
	
	public static void main(String[] args) {
		
		DVD dvd = new DVD("titlea","Quentin",1,"commentttt");
		dvd.print();

	}

}
