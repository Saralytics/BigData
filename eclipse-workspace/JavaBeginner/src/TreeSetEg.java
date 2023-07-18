import java.util.*;

public class TreeSetEg {

	public static void main(String[] args) {
		// create an empty treeset
		TreeSet<String> ts = new TreeSet<String>();
		
		// add elements to it 
		ts.add("leaves");
		ts.add("flowers");
		ts.add("fruits");
		
		for (String value : ts)
			System.out.println(value);
		

	}

}
