package Account;

import java.util.ArrayList;
import java.util.List;

public class Account {

private String bankName;
private String accountType;
private double accountBalance;
private double interestRate;
private double overdrawAllowed;

public Account(String accountType, String bankName, double interestRate, double overdrawAllowed) {
	this.accountType = accountType;
	this.bankName = bankName;
	this.interestRate = interestRate;
	this.overdrawAllowed = overdrawAllowed;
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

	public boolean deposit(double amount) {
		if (amount > 0.0) {
			accountBalance = accountBalance + amount;
			return true;
	    }
		return false;
	}

	public boolean withdraw(double amount) {
		if ((amount > 0.0) && ((accountBalance - amount) >= (this.overdrawAllowed)*-1)) {
			accountBalance = accountBalance - amount;
			return true;
		}
		return false;
	}

}
