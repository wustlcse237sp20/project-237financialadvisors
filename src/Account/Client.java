package Account;

import java.util.ArrayList;
import java.util.List;

public class Client {
	List<Account> Accounts = new ArrayList<Account>();
	Double totalWealth;
	Double ARR;
	int age;

	public Client(List<Account> Accounts, int age) {
		this.Accounts = Accounts;
		this.age = age;
		this.totalWealth = calculateTotalWealth();
		this.ARR = calculateAverageRateOfReturn();
	}

	public List<Account> getAccounts() {
		return Accounts;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getTotalWealth() {
		return totalWealth;
	}
	
	public double getAverageRateOfReturn() {
		return ARR;
	}
	
	public boolean deleteAccount(int accountNumber) {
		int account = -1;
		for (int i =0; i<Accounts.size(); i++) {
			if (accountNumber == Accounts.get(i).getAccountNumber()) {
				account = i;
			}
		}
		Accounts.remove(account);
		return true;
	}
	
	public void addAccount(Account a) {
		Accounts.add(a);
	}
	
	public boolean transferMoney(int accountWithdrawNumber, int accountDepositNumber, double amount) {
		int accountWithdraw = -1;
		int accountDeposit = -1;
		for (int i = 0; i<Accounts.size(); i++) {
			if (accountWithdrawNumber == Accounts.get(i).getAccountNumber()) {
				accountWithdraw = i;
			}
			if (accountDepositNumber == Accounts.get(i).getAccountNumber()) {
				accountDeposit = i;
			}
		}
		Accounts.get(accountWithdraw).withdraw(amount); 
		Accounts.get(accountDeposit).deposit(amount);
		return true;
	}

	/**
	 * Prints out all the client's accounts
	 * @param 
	 */
	public void generateAccounts() {
		for (int i =0; i<Accounts.size(); i++) {
			System.out.println("Account " + (i+1) + ":");
			System.out.println(Accounts.get(i));
		}
	}
	/**
	 * Calculates the client's total wealth
	 * @param 
	 * @return the client's total wealth (int)
	 */
	public double calculateTotalWealth() {
		double totalWealth = 0.0;
		for (int i =0; i<Accounts.size(); i++) {
			totalWealth = totalWealth + Accounts.get(i).getBalance();
		}
		System.out.println("Your total wealth is: $" + totalWealth);
		return totalWealth;
	}
	
	/**
	 * Calculates the percentage of client's wealth that is in an account
	 * @param 
	 * @return the percentage of wealth in an account (int)
	 */
	public void calculatePercentagesByAccount() {
		double percentage = 0.0;
		for (int i =0; i<Accounts.size(); i++) {
			percentage = Math.round((Accounts.get(i).getBalance()/totalWealth)*10000.0)/100.0;
			System.out.print(percentage + "% of your wealth is in account " + (i+1) + ", ");
		}
	}
	
	/**
	 * Calculates the client's average rate of return across all accounts
	 * @param 
	 * @return client's average rate of return (int)
	 */
	public double calculateAverageRateOfReturn() {
		double ARR = 0.0;
		for (int i=0; i<Accounts.size(); i++) {
			ARR = ARR + (Accounts.get(i).getInterestRate())*Accounts.get(i).getBalance();
		}
		ARR = Math.round((ARR/(totalWealth))*100.0)/100.0;
		System.out.println("Your average rate of return across all accounts is: " +  ARR);
		return ARR;
	}

	/**
	 * Calculates the number of a specified account the client has
	 * @param client, accountType
	 * @return number of accounts for a type of account
	 */
	public int numberOfATypeOfAccount(Client client, String accountType) {
		int numberOfThisAccountType = 0;
		
		List<Account> clientAccounts = client.getAccounts();
		for (int i = 0; i < clientAccounts.size(); i++) {
			if (clientAccounts.get(i).getAccountType() == accountType) {
				numberOfThisAccountType += 1;
			}
		}
		
		return numberOfThisAccountType;
	}
	
	/**
	 * Finds the highest interest rate in a list of accounts
	 * @param Accounts
	 * @return interest rate (double)
	 */
	public Account findHighestInterestRate(List<Account> Accounts) {
		double highestInterestRate = 0.0;
		Account highestRateAccount = new Account(null, null, 0, 0, 0);
		for (int i = 0; i < Accounts.size(); i++) {
			if (Accounts.get(i).getInterestRate() > highestInterestRate) {
				highestInterestRate = Accounts.get(i).getInterestRate();
				highestRateAccount = Accounts.get(i);
			}
		}
		
		return highestRateAccount;
		
	}
	
//	public void calculatePercentagesByAccountType() {
//		double savingsPercentage = 0.0;
//		double checkingsPercentage = 0.0;
//		double stocksPercentage = 0.0;
//		double bondsPercentage = 0.0;
//		for (int i=0; i<Accounts.size();i++) {
//			if (Accounts.get(i).getAccountType() == "savings") {
//				savingsPercentage = savingsPercentage + Accounts.get(i).getBalance();
//			}
//			if (Accounts.get(i).getAccountType() == "checkings") {
//				checkingsPercentage = checkingsPercentage + Accounts.get(i).getBalance();
//			}
//			if (Accounts.get(i).getAccountType() == "stocks") {
//				stocksPercentage = stocksPercentage + Accounts.get(i).getBalance();
//			}
//			if (Accounts.get(i).getAccountType() == "bonds") {
//				bondsPercentage = bondsPercentage + Accounts.get(i).getBalance();
//			}	
//		}
//		System.out.println((savingsPercentage/totalWealth) + "% of your wealth is in savings accounts");
//		System.out.println((checkingsPercentage/totalWealth) + "% of your wealth is in checkings accounts");
//		System.out.println((stocksPercentage/totalWealth) + "% of your wealth is in stocks accounts");
//		System.out.println((bondsPercentage/totalWealth) + "% of your wealth is in bonds accounts");
//	}


}