class Cat {
	int eyes = 2;
	String fur="black";
	public void jump() {
		System.out.println("Cats love to jump");
	}
}

class Kitten extends Cat{
	String fur = "grey";
	
	public void jump() {
		System.out.println("Kittens can jump too");
	}
}

public class KittenTest {

	public static void main(String[] args) {
		Kitten obj = new Kitten();
		obj.jump();
		System.out.println(obj.fur);

	}
}
