class Dog{
	String sound = "WOOF";
	int age = 5;
	
	public void bark() {
		System.out.print("Dogs sound like WOOF");
	}

}

class Puppy extends Dog{
	String sound = "woof";
	int age = 1;
	
	public void bark() {
		System.out.println("Puppy say woof");
	}
}

public class PuppyTest {

	public static void main(String[] args) {
		Puppy obj = new Puppy();
		obj.bark();
		System.out.println(obj.age);

	}

}



