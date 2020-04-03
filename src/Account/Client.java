package Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	static List<Account> Accounts = new ArrayList<Account>();
	
	public Client() {
//		Accounts = new ArrayList<Account>(5);
	}
		public static void generateSummary() {
			for (int i =0; i<Accounts.size(); i++) {
				System.out.println(Accounts.get(i));
			}
		}
			public static void main(String[] args) {
				String accountType = "";
				String bankName = "";
				Double interest = 0.0;
				Double overdraw = 0.0;
				int accountNumber = 0;
				// Double accountBalance = 0.0;
				Scanner type = new Scanner(System.in);
				System.out.println("How many accounts do you have to add?");
				int number = type.nextInt();
				for (int i = 1; i<=number; i++) {
					System.out.println("Account " + i + ":");
					System.out.println("Enter the type of account e.g. checkings, savings, stocks, bonds: ");
					accountType = type.next();
					System.out.println("Enter the name of the bank: ");
					bankName = type.next();
					System.out.println("Enter the account number: ");
					accountNumber = type.nextInt();
					System.out.println("Enter the interest rate: ");
					interest = type.nextDouble();
					System.out.println("How much can you overdraw in this account?");
					overdraw = type.nextDouble();
					Account newAccount = new Account(accountType, bankName, interest, overdraw, accountNumber);
					// System.out.println(accountType + " " + bankName + " " + interest + " " + overdraw);
					Accounts.add(newAccount);
				}
				type.close();
				System.out.flush();
				generateSummary();
			}
}