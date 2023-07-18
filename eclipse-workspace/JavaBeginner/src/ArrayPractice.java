class ArrayBank {
	int customerID = 72634;
	String customerName = "Li";
	float accountBalance = 823874.5f;
	
	public void printCustomerDetails() {
		System.out.println("This prints customer details: ");
	}
	
}
public class ArrayPractice {

	public static void main(String[] args) {
		ArrayBank customer1 = new ArrayBank();
		customer1.printCustomerDetails();
		ArrayBank customer2 = new ArrayBank();
		ArrayBank customer3 = new ArrayBank();

	}

}
