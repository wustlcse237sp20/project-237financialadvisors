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

	public void addAccount(Account a) {
		Accounts.add(a);
	}

	/**
	 * 
	 * @param accountNumber
	 * @return true if successful 
	 */
	public boolean deleteAccount(int accountNumber) {
		int account = -1;
		for (int i =0; i<Accounts.size(); i++) {
			if (accountNumber == Accounts.get(i).getAccountNumber()) {
				account = i;
			}
		}
		if (account != -1) {
			Accounts.remove(account);
			return true;
		}
		return false;
	}


	/**
	 * enables client to be able to transfer money between accounts
	 * @param accountWithdrawNumber
	 * @param accountDepositNumber
	 * @param amount
	 * @return true if successful 
	 */
	public boolean deposit(int accountNumber, int amount) {
		int account = -1;
		for (int i = 0; i<Accounts.size(); i++) {
			if (accountNumber == Accounts.get(i).getAccountNumber()) {
				account = i;
			}
		}
		Accounts.get(account).deposit(amount);
		return true;
	}
	
	public boolean withdraw(int accountNumber, int amount) {
		int account = -1;
		for (int i = 0; i<Accounts.size(); i++) {
			if (accountNumber == Accounts.get(i).getAccountNumber()) {
				account = i;
			}
		}
		Accounts.get(account).withdraw(amount);
		return true;
	}
	
	
	public void setAge(int age) {
		this.age = age;
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
		if ((accountWithdraw != -1) && (accountDeposit != -1) && (amount > 0.0)) {
			Accounts.get(accountWithdraw).withdraw(amount); 
			Accounts.get(accountDeposit).deposit(amount);
			return true;
		}
		return false;
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
	 * @return the percentage of wealth in an account (double)
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
	 * @return client's average rate of return (double)
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

	/**
	 * 
	 * @param client
	 * @param years
	 * @param compound (number of times per year)
	 * @return updated totalWealth
	 */
	public boolean interestRateCalculator (Client client, int years, int compound) {
		if ((years>0) && (compound>0)) {
			double interestRate = client.getAverageRateOfReturn();
			double interestGenerated = Math.pow(1+((interestRate*0.01)/compound), 60);
			totalWealth = Math.round((client.getTotalWealth()*interestGenerated)*100.0)/100.0;
			return true;
		}
		return false;
	}

}