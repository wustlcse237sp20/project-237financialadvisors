package FinancialAdvisorApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Account.Account;
import Account.Client;

public class FinancialAdvisorApp {

	public static void main(String[] args) {
		List<Account> Accounts = new ArrayList<Account>();
		Scanner type = new Scanner(System.in);
		System.out.println("How many accounts do you have to add?");
		int number = type.nextInt();
		System.out.println("How old are you?");
		int age = type.nextInt();
		Client a = new Client(Accounts, age);
		for (int i = 1; i<=number; i++) {
			System.out.println("Account " + i + ":");
			System.out.println("Enter the type of account e.g. checkings, savings, stocks, bonds: ");
			String accountType = type.next();
			System.out.println("Enter the name of the bank: ");
			String bankName = type.next();
			System.out.println("Enter the account number: ");
			int accountNumber = type.nextInt();
			System.out.println("Enter the interest rate: ");
			Double interest = type.nextDouble();
			System.out.println("How much can you overdraw in this account?");
			Double overdraw = type.nextDouble();
			Account newAccount = new Account(accountType, bankName, interest, overdraw, accountNumber);
			System.out.println("How much money is currently in this account?");
			Double balance = type.nextDouble();
			newAccount.deposit(balance);
			Accounts.add(newAccount);
			System.out.flush();
		}
		type.close();
		a.getAverageRateOfReturn();
		a.generateAccounts();
		a.calculatePercentagesByAccount();
		//a.calculatePercentagesByAccountType();
	}
}
