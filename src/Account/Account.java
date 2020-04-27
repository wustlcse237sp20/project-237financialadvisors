package Account;

public class Account {

	private String bankName;
	private String accountType;
	private double accountBalance;
	private double interestRate;
	private double overdrawAllowed;
	private int accountNumber;

	public Account(String accountType, String bankName, double interestRate, double overdrawAllowed, int accountNumber) {
		this.accountType = accountType;
		this.bankName = bankName;
		this.interestRate = interestRate;
		this.overdrawAllowed = overdrawAllowed;
		this.accountNumber = accountNumber;
	}

	public String getNameOfBank() {
		return bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return accountBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getOverdrawAllowed() {
		return overdrawAllowed;
	}
	
	/**
	 * 
	 * @param amount
	 * @return true if deposit is successful, false otherwise 
	 */
	public boolean deposit(double amount) {
		if (amount > 0.0) {
			accountBalance = accountBalance + amount;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param amount
	 * @return true if withdraw is successful, false otherwise
	 */
	public boolean withdraw(double amount) {
		if ((amount > 0.0) && ((accountBalance - amount) >= (this.overdrawAllowed)*-1)) {
			accountBalance = accountBalance - amount;
			return true;
		}
		return false;
	}

	public String toString() {
		return "Account Type: " + accountType + ", " + bankName + ", Account #: " + accountNumber + ", Balance: " + accountBalance + ", Interest Rate:" + interestRate + ", " + "Amount allowed to overdraw: " + overdrawAllowed; 
	}

}
