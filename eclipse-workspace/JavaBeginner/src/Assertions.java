import java.io.File;
import java.io.IOException;

public class Assertions {

	public static void main(String[] args) throws IOException {
		
		int value = 100;
		try {
			assert value >= 189: "Not valid";
		} catch (AssertionError e) {
			e.printStackTrace();
		}
		
	}

}
