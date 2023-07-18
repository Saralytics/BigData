import java.util.Scanner;

class HDFC{
	private int customerId;
	public String customerName;
	float balance = 10000.5f;
	
	public void withdraw(float amount) {
		balance=balance-amount;
		System.out.println("Updated balance is " + balance);
	}
	
	public void deposit(float amount) {
		balance=balance+amount;
		System.out.println("Updated balance is " + balance);
		
	}
	
	public void addNominee(String nomineeName, int accountNumber) {
		
		System.out.println("Added nominee "+nomineeName+"Account number is " + accountNumber);
		
	}
	
	public void checkBalance(float balance) {
		System.out.println("Balance is "+ balance);
	}
	
	public void checkBalance() {
		System.out.println("Balance is unabailable");
	}
	
}

class HDFCMumbai extends HDFC{
	
	public void addNominee(int accountNumber) {
		System.out.println("Added nominee Account number is " + accountNumber);
	}
	
}

public class HDFCBankTest {

	public static void main(String[] args) {
		HDFC obj = new HDFC();
		System.out.println("Welcome to HDFC!");
		System.out.println("Press 1 for withdraw "
				+ "\n Press 2 for deposit "
				+ "\n Press 3 for adding nominee to your account"
				+ "\n Press 4 for adding payee to your account"
				+ "\n Press 5 for exit");
		
		Scanner keyboard = new Scanner(System.in);
		int choice;
		choice = keyboard.nextInt();
		System.out.println("You have chosen: "+choice);
		
		if(choice==1) {
			System.out.println("How much to withdraw?");
			float amountWithdraw = keyboard.nextFloat();
			obj.withdraw(amountWithdraw);
		}
		else if(choice==2) {
			System.out.println("How much to deposit?");
			float amountDeposit = keyboard.nextFloat();
			obj.deposit(amountDeposit);
		}
		else if(choice==5) {
			System.out.println("Look forward to see you again");
		}
		else if(choice==3) {
			
			for(int i=1;i<=10;i++) {
				System.out.println("Whats the nominee name?");
				
				String name = keyboard.next();
				
				System.out.println("Whats the nominee account?");
				
				int account = keyboard.nextInt();
				
				obj.addNominee(name, account);
			
			}
			
		}

	}

}
