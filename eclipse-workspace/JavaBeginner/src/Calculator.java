
public class Calculator {
	public void add(int number1, int number2) {
		int sum = number1 + number2;
		System.out.println("Sum is " + sum);
	}
	public void add(int number1, float number2) {
		float sum = number1 + number2;
		System.out.println("Sum is " + sum);
	}
	
	public void add(float number1, float number2) {
		float sum = number1 + number2;
		System.out.println("Sum is " + sum);
		
	}
	
	public void add(float number1, int number2) {
		float sum = number1 + number2;
		System.out.println("Sum is "+sum);
		
	}
	
	public void subtraction(int number1, int number2) {
		float result = number1 - number2;
		System.out.println("Subtract 1 number "+ result);
		
	}
	
	public void subtraction(int number1, int number2, int number3) {
		float result = number1 - number2 - number3;
		System.out.println("Subtract 2 numbers "+ result);
		
	}
	
	public static void main(String[] args) {
		Calculator obj = new Calculator();
		obj.add(3, 4);
		obj.add(5.6f, 7.8f);
		obj.subtraction(3, 4);
		obj.subtraction(3,1,2);

	}

}
