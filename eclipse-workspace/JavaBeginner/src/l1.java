import java.util.*;

public class l1 {
	// main driver method 
	public static void main(String[] args) {
		// creating an array list class object
		// declaring object of integer type 
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		// iterating over the list 
		for (int i=0; i<5; i++)
			al.add(i);
		
		// Print out elements in the list 
		System.out.println(al);
		
		Iterator<Integer> itr = al.iterator();
		
		while(itr.hasNext()) {
			int i = itr.next();
		
			// remove element if the element is odd 
			if(i%2 != 0)
				itr.remove();
		}
		
		// finally print the list 
		System.out.println(al);
		

	}

}
