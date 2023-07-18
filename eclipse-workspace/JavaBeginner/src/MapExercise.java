import java.util.*;

public class MapExercise {

	public static void main(String[] args) {
		// start a scanner instance 
		Scanner keyboard = new Scanner(System.in);
		
		// start a map 
		Map<Integer, String> m = new HashMap();
		
		// ask for user input 
		System.out.println("Enter your id ");
		int id = keyboard.nextInt();
		System.out.println("Enter your wish ");
		String wish = keyboard.next();
		
		// and add it to the map
		
		m.put(id,wish);
		
		// feedback
		System.out.println("Your are "+id +", your wish is "+wish);
	}

}
