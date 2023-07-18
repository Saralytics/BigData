import java.util.*; 

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// create a linkedHashSet
		LinkedHashSet<String> linkedset 
		= new LinkedHashSet<String>();
		
		linkedset.add("Apple");
		linkedset.add("Banana");
		linkedset.add("Coconut");
		linkedset.add("Durian");
		linkedset.add("Eww");
		
		Iterator<String> i = linkedset.iterator();
		
		while (i.hasNext())
			System.out.print(i.next() + ",");

	}

}
