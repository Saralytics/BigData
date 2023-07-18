import java.util.*;

enum MyWords {CODE, LEARN, CONTRIBUTE, QUIZ};

public class EnumDemo {

	public static void main(String[] args) {
		Set<MyWords> hs1; // creating a set using enum MyWords
		
		hs1 = EnumSet.of(MyWords.QUIZ, MyWords.LEARN); // add words to the set
		
		System.out.println(hs1);

	}

}
