package dome;

import java.util.ArrayList;

public class Database {
	// add new CDs, list CDs, 

	ArrayList<Item> listItem= new ArrayList<Item>();
	
	// use the overload feature to create 1 add() function, 
	// one add cd, one add dvd 
	
	public void add(Item item) {
		listItem.add(item);
	}
	
	public void list() {
		for (Item item : listItem) {
			item.print();
		}
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		
		// adding 1st new cd 
		CD newCD1 = new CD("Plattinum","Taylor",8,100,"Sold a lot");
		db.add(newCD1);
//		
		// adding 2nd new cd 
		CD newCD2 = new CD("Hello","Adele",10,120,"Famous album");
		db.add(newCD2);
//		
		// adding 1st new dvd 
		DVD newDVD1 = new DVD("Glorious bastered","Tarantino",120,"Very good");
		db.add(newDVD1);
				
		// adding 2nd new dvd 
		DVD newDVD2 = new DVD("Hello","Adele",50,"Music work");
		db.add(newDVD2);
		
		db.list();

	}

}
