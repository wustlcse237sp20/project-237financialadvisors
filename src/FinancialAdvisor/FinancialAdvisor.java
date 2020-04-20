package FinancialAdvisor;

import Account.Client;

import java.util.ArrayList;
import java.util.List;

import Account.Account;

public class FinancialAdvisor {
	
	private Client client;

	public FinancialAdvisor(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	
	/**
	 * Consolidates the client's accounts, checking for multiple accounts of the same type and determining
	 * which has a higher interest rate then moving money around to optimize the client portfolio
	 * @param client
	 * @return true if action completed, false if not
	 */
	
	//can be broken up into multiple methods
	public boolean consolidateAccounts(Client client) {
		boolean accountConsolidated = false;
		String outputMessage1 = "";
		String outputMessage2 = "";
		List<Account> clientAccounts = client.getAccounts();
		List<Account> clientSavingsAccounts = new ArrayList<Account>();
		List<Account> clientCheckingAccounts = new ArrayList<Account>();

		if (client.numberOfATypeOfAccount(client, "checkings") > 1) {
			Account checkingsHighestAccount = new Account(null, null, 0, 0, 0);
			for (int i = 0; i < clientAccounts.size(); i++) {
					
					if (clientAccounts.get(i).getAccountType() == "checkings") {
						clientCheckingAccounts.add(clientAccounts.get(i));
					}
			}
			checkingsHighestAccount = client.findHighestInterestRate(clientCheckingAccounts);
			outputMessage1 = "The highest checkings account interest rate is " + checkingsHighestAccount.getInterestRate() + ". You should transfer funds to the checkings account with this interest rate.";
			clientCheckingAccounts.remove(checkingsHighestAccount);
			
			for (int i = 0; i < clientCheckingAccounts.size(); i++) {
				int withdrawAccountNumber = clientCheckingAccounts.get(i).getAccountNumber();
				client.transferMoney(withdrawAccountNumber, checkingsHighestAccount.getAccountNumber(), clientCheckingAccounts.get(i).getBalance());
				client.deleteAccount(withdrawAccountNumber);
			}
			accountConsolidated = true;
		}
		
		else if (client.numberOfATypeOfAccount(client, "savings") > 1) {
			Account savingsHighestAccount = new Account(null, null, 0, 0, 0);
			for (int i = 0; i < clientAccounts.size(); i++) {
				
				if (clientAccounts.get(i).getAccountType() == "savings") {
					clientSavingsAccounts.add(clientAccounts.get(i));
				}
			}
			savingsHighestAccount = client.findHighestInterestRate(clientSavingsAccounts);
			outputMessage2 = "The highest savings account interest rate is " + savingsHighestAccount.getInterestRate() + ". You should transfer funds to the savings account with this interest rate.";
			clientSavingsAccounts.remove(savingsHighestAccount);
			
			for (int i = 0; i < clientSavingsAccounts.size(); i++) {
				int withdrawAccountNumber = clientSavingsAccounts.get(i).getAccountNumber();
				client.transferMoney(withdrawAccountNumber, savingsHighestAccount.getAccountNumber(), clientSavingsAccounts.get(i).getBalance());
				client.deleteAccount(withdrawAccountNumber);
			}
			accountConsolidated = true;
		}
		
		System.out.print(outputMessage1);
		System.out.print(outputMessage2);
		return accountConsolidated;
	}
	

	/**
	 * Determines the optimal ARR for the client and compares it to the current ARR (prints out a statement for client to see)
	 * @param client
	 * @return client's optimal average rate of return
	 */
	public double optimalRiskByAgeBracket(Client client) {
		double averageRateOfReturn = 0.0;
		double currentClientARR = client.calculateAverageRateOfReturn();
		String compareOptimalAndClientARR = "";
		
		if (client.getAge() < 18) {
			return averageRateOfReturn;
		}
		else if (client.getAge() >= 18 && client.getAge() < 30) {
			if (currentClientARR >= 16 && currentClientARR < 20) {
				averageRateOfReturn = currentClientARR;
			}
			else {
				averageRateOfReturn = 16.0;
			}
		}
		else if (client.getAge() >= 30 && client.getAge() < 40) {
			if (currentClientARR >= 12 && currentClientARR < 16) {
				averageRateOfReturn = currentClientARR;
			}
			else {
				averageRateOfReturn = 12.0;
			}
		}
		else if (client.getAge() >= 40 && client.getAge() < 50) {
			if (currentClientARR >= 9 && currentClientARR < 12) {
				averageRateOfReturn = currentClientARR;
			}
			else {
				averageRateOfReturn = 9.0;
			}
		}
		else if (client.getAge() >= 50 && client.getAge() < 60) {
			if (currentClientARR >= 6 && currentClientARR < 9) {
				averageRateOfReturn = currentClientARR;
			}
			else {
				averageRateOfReturn = 6.0;
			}
		}
		else if (client.getAge() >= 60) {
			if (currentClientARR >= 3 && currentClientARR < 6) {
				averageRateOfReturn = currentClientARR;
			}
			else {
				averageRateOfReturn = 3.0;
			}
		}
		
		if (currentClientARR > averageRateOfReturn) {
			compareOptimalAndClientARR = "greater than";
		}
		else if (currentClientARR < averageRateOfReturn) {
			compareOptimalAndClientARR = "less than";
		}
		else if (currentClientARR == averageRateOfReturn) {
			compareOptimalAndClientARR = "equal to";
		}
		
		System.out.print("Your current ARR is: " + currentClientARR + "%, which is " + compareOptimalAndClientARR + " the optimal ARR of " + averageRateOfReturn + "% for your age bracket.");
		
		return averageRateOfReturn;
	}
	
	public boolean recommendHigherYieldAccounts() {
		boolean recommendedAccount = false;
		
		
		return recommendedAccount;
	}
}
