package FinancialAdvisorApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Account.Account;
import Account.Client;
import FinancialAdvisor.FinancialAdvisor;

public class FinancialAdvisorApp {

	public static void main(String[] args) {
//		List<Account> Accounts = new ArrayList<Account>();
//		Scanner type = new Scanner(System.in);
//		System.out.println("How many accounts do you have to add?");
//		int number = type.nextInt();
//		System.out.println("How old are you?");
//		int age = type.nextInt();
//		Client newClient = new Client(Accounts, age);
//		FinancialAdvisor financialAdvisor = new FinancialAdvisor(newClient);
//		for (int i = 1; i<=number; i++) {
//			System.out.println("Account " + i + ":");
//			System.out.println("Enter the type of account e.g. checkings, savings, stocks, bonds: ");
//			String accountType = type.next();
//			System.out.println("Enter the name of the bank: ");
//			String bankName = type.next();
//			System.out.println("Enter the account number: ");
//			int accountNumber = type.nextInt();
//			System.out.println("Enter the interest rate: ");
//			Double interest = type.nextDouble();
//			System.out.println("How much can you overdraw in this account?");
//			Double overdraw = type.nextDouble();
//			Account newAccount = new Account(accountType, bankName, interest, overdraw, accountNumber);
//			System.out.println("How much money is currently in this account?");
//			Double balance = type.nextDouble();
//			newAccount.deposit(balance);
//			Accounts.add(newAccount);
//			System.out.flush();
//		}
//		type.close();
//		newClient.getAverageRateOfReturn();
//		newClient.generateAccounts();
//		newClient.calculatePercentagesByAccount();
//		financialAdvisor.optimalRiskByAgeBracket(newClient);
//		financialAdvisor.consolidateAccounts(newClient);
//		//a.calculatePercentagesByAccountType();
		
		List<Account> Account2 = new ArrayList<Account>();
		Account f = new Account("savings", "capitalone", 1.7, 300.0, 987654321);
		f.deposit(1200.0);
		Account2.add(f);
		Account g = new Account("savings", "chase", 0.2, 800.0, 987644321);
		g.deposit(2200.0);
		Account2.add(g);
		Account h = new Account("investment", "TD", 7.0, 0.0, 487654321);
		h.deposit(405.0);
		Account2.add(h);
		Account i = new Account("checkings", "citi", 0.1, 300.0, 987654321);
		i.deposit(8097.66);
		Account2.add(i);
		Account j = new Account("savings", "ally", 2.0, 300.0, 987654321);
		j.deposit(4563.0);
		Account2.add(j);
		Client two = new Client(Account2, 55);
		two.getAverageRateOfReturn();
		
		List<Account> Account1 = new ArrayList<Account>();
		Account a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		a.deposit(500.0);
		Account1.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 87654321);
		b.deposit(300.0);
		Account1.add(b);
		Account c = new Account("investments", "fidelity", 7.0, 0.0, 56781234);
		c.deposit(700.0);
		Account1.add(c);
		Account d = new Account("bonds", "etrade", 3.0, 0.0, 43218765);
		d.deposit(300.0);
		Account1.add(d);
		Account e = new Account("investments", "etrade", 8.0, 0.0, 34561278);
		e.deposit(200.0);
		Account1.add(e);
		Client one = new Client(Account1, 27);
		one.generateAccounts();
		System.out.println();
		String accountList = "Account 1: " + "\n" + "Account Type: savings, chase, Account #: 12345678, Balance: 500.0, Interest Rate: 0.2, Amount allowed to overdraw: 500.0" + "\n" + "Account 2: " + "\n" + "Account Type: checkings, boa, Account #: 87654321, Balance: 300.0, Interest Rate: 0.0, Amount allowed to overdraw: 100.0" + "\n" + "Account 3: " + "\n" + "Account Type: investments, fidelity, Account #: 56781234, Balance: 700.0, Interest Rate: 7.0, Amount allowed to overdraw: 0.0" + "\n" + "Account 4: " + "\n" +"Account Type: bonds, etrade, Account #: 43218765, Balance: 300.0, Interest Rate: 3.0, Amount allowed to overdraw: 0.0" + "\n" + "Account 5: " + "\n" + "Account Type: investments, etrade, Account #: 34561278, Balance: 200.0, Interest Rate: 8.0, Amount allowed to overdraw: 0.0";
		System.out.println(accountList);
	}
}
