package dome;

public class CD  extends Item {
	
	
	private String artist;
	private int numberofTracks;
	
	
	
	//Create a constructor 
	//A constructor in Java is a special method that is used to initialize objects. The constructor is called when an object of a class is created. It can be used to set initial values for object attributes:
	
	public CD(String title, String artist, int numberofTracks, int playingTime, String comment) {
		super(title, playingTime, false, comment); // comes from the parent class 
		
		this.artist = artist;
		this.numberofTracks = numberofTracks;
	}
	
	public static void main(String[] args) {
		CD cd = new CD("a","b",2,2,"...");
		CD cd1 = new CD("a","b",2,2,"...");

		System.out.println(cd.equals(cd1));
		cd.print(); // this print comes from Item

	}

//	@Override
	public boolean equals(CD obj) {
		
		return artist.equals(obj.artist);
	}

//	public void print() {
//		System.out.println("CD: " + title + " : " + artist);
//		
//	}

}
