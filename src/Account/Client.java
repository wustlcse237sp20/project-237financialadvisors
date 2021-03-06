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

	public void setAge(int age) {
		this.age = age;
	}

	public void addAccount(Account a) {
		Accounts.add(a);
	}

	/**
	 * Delete account from arraylist of accounts
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
	 * enables client to be able to deposit money
	 * @param accountNumber
	 * @param amount
	 * @return true if successful 
	 */
	public boolean deposit(int accountNumber, double amount) {
		int account = -1;
		for (int i = 0; i<Accounts.size(); i++) {
			if (accountNumber == Accounts.get(i).getAccountNumber()) {
				account = i;
			}
		}
		if (account != -1) {
			Accounts.get(account).deposit(amount);
			return true;
		}
		return false;
	}

	/**
	 * enables client to be able to withdraw from accounts
	 * @param accountnumber
	 * @param amount
	 * @return true if successful 
	 */
	public boolean withdraw(int accountNumber, double amount) {
		int account = -1;
		for (int i = 0; i<Accounts.size(); i++) {
			if (accountNumber == Accounts.get(i).getAccountNumber()) {
				account = i;
			}
		}
		if (account != -1) {
			Accounts.get(account).withdraw(amount);
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
		//System.out.println("Your total wealth is: $" + totalWealth);
		this.totalWealth = totalWealth;
		return totalWealth;
	}

	/**
	 * Calculates the percentage of client's wealth that is in an account
	 * @param 
	 * @return the percentage of wealth in an account (double)
	 */
	public String calculatePercentagesByAccount(Client client) {
		double percentage = 0.0;
		double percentagesByAccount[] = new double[client.Accounts.size()];
		String percentageString = "";
		for (int i =0; i<Accounts.size(); i++) {
			percentage = Math.round((Accounts.get(i).getBalance()/calculateTotalWealth())*10000.0)/100.0;
			percentagesByAccount[i] = percentage;
			System.out.print(percentage + "% of your wealth is in account # " + (i+1) + ", ");
			percentageString  = percentageString + percentage + " % of your wealth is in account #" + client.Accounts.get(i).getAccountNumber() + "\n";
		}
		return percentageString;
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
		ARR = Math.round((ARR/(calculateTotalWealth()))*100.0)/100.0;
		this.ARR = ARR;
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
			if (clientAccounts.get(i).getAccountType().equals(accountType)) {
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
	 * Calculates potential future wealth based on having the current amount of money in the account for a number of years
	 * @param client
	 * @param years
	 * @param compound (number of times per year)
	 * @return String of updated totalWealth for future
	 */
	public String interestRateCalculator (Client client, int years, int compound) {
		double totalWealthFuture = 0.0;
		if ((years>0) && (compound>0)) {
			double interestRate = client.getAverageRateOfReturn();
			double interestGenerated = Math.pow(1+((interestRate*0.01)/compound), years*compound);
			totalWealthFuture = Math.round((client.calculateTotalWealth()*interestGenerated)*100.0)/100.0;
			String message = "In " + years + " years you will have: $" + totalWealthFuture;
			System.out.println("In " + years + " years you will have: $" + totalWealthFuture);
			return message;
		}
		String x = "Enter appropriate inputs";
		System.out.print("Enter appropriate inputs");
		return x;
	}

	/**
	 * Checks for duplicate account numbers (since account number should be unique)
	 * @param client
	 * @param accountNumber
	 * @return whether or not account number is a duplicate of existing account
	 */
	public boolean duplicateAccountNumber(Client client, int accountNumber) {
		for (int i = 0; i <client.getAccounts().size(); i++) {
			if (client.getAccounts().get(i).getAccountNumber() == accountNumber) {
				return false;
			}
		}
		return true;
	}

}