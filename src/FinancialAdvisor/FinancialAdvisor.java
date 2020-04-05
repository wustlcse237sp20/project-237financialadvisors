package FinancialAdvisor;

import Account.Client;

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
	
	public boolean consolidateAccounts(Client client) {
		boolean accountConsolidated = false;
		List<Account> clientAccounts = client.getAccounts();
		
		if (client.numberOfATypeOfAccount(client, "checkings") > 1) {
			for (int i = 0; i < clientAccounts.size(); i++) {
					
					if (clientAccounts.get(i).getAccountType() == "checkings") {
					}
					
					if (clientAccounts.get(i).getAccountType() == "savings") {
						
					}
			}
		}
		
		if (client.numberOfATypeOfAccount(client, "savings") > 1) {
			
		}

		return accountConsolidated;
	}
	

	
	public double optimalRiskByAgeBracket(Client client) {
		double averageRateOfReturn = 0.0;
		double currentClientARR = client.calculateAverageRateOfReturn();
		String compareOptimalAndClientARR = "";
		
		if (client.getAge() < 18) {
			return averageRateOfReturn;
		}
		else if (client.getAge() >= 18 && client.getAge() < 30) {
			averageRateOfReturn = 15.0;
		}
		else if (client.getAge() >= 30 && client.getAge() < 40) {
			averageRateOfReturn = 10.0;
		}
		else if (client.getAge() >= 40 && client.getAge() < 50) {
			averageRateOfReturn = 8.0;
		}
		else if (client.getAge() >= 50 && client.getAge() < 60) {
			averageRateOfReturn = 6.0;
		}
		else if (client.getAge() >= 60) {
			averageRateOfReturn = 5.0;
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
		
		System.out.print("Your current ARR is: " + currentClientARR + "%, which is " + compareOptimalAndClientARR + "the optimal ARR of " + averageRateOfReturn + "% for your age bracket.");
		
		return averageRateOfReturn;
	}
}
