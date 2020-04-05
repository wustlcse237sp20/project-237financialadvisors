package FinancialAdvisor;

import Account.Client;

public class FinancialAdvisor {
	
	private Client client;

	public FinancialAdvisor(Client client) {
		this.client = client;
	}
	
	public static void consolidateAccounts(Client client) {
		//for loop iterating through clients accounts
			//if checkings
				//compaire interest rates, move money
			//if savings
				//compaire interest rates, move money
			//if investments
				//compaire interest rates, move money
		
	}
	
	public double optimalRiskByAgeBracket(Client client) {
		double averageRateOfReturn = 0.0;
		
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
		
		System.out.print("Your optimal ARR for your age bracket is: " + averageRateOfReturn);
		
		return averageRateOfReturn;
	}
}
