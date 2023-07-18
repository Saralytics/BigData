import java.util.*;

public class GFG {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("B");
		hs.add("B");
		hs.add("C");
		hs.add("D");
	
		String check = "D";
		
		System.out.println("Contains " + check + " is " + hs.contains(check));
		
		hs.remove("B");
		System.out.println("After removing: " + hs);
		
		Iterator<String> i = hs.iterator();
		
		while (i.hasNext())
			System.out.println(i.next());

	}

}
