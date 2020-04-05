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

	public int getAge() {
		return age;
	}
	public Double calculateTotalWealth() {
		Double totalWealth = 0.0;
		for (int i =0; i<Accounts.size(); i++) {
			totalWealth = totalWealth + Accounts.get(i).getBalance();
		}
		System.out.println("Your total wealth is: $" + totalWealth);
		return totalWealth;
	}
	
	public Double getTotalWealth() {
		return totalWealth;
	}
	
	public Double getAverageRateOfReturn() {
		return ARR;
	}

	public List<Account> getAccounts() {
		return Accounts;
	}

	public void generateAccounts() {
		for (int i =0; i<Accounts.size(); i++) {
			System.out.println("Account " + (i+1) + ":");
			System.out.println(Accounts.get(i));
		}
	}

	public void calculatePercentagesByAccount() {
		Double percentage = 0.0;
		for (int i =0; i<Accounts.size(); i++) {
			percentage = ((Accounts.get(i).getBalance())/totalWealth)*1.00*100;
			System.out.print(percentage + "% of your wealth is in account " + (i+1) + ", ");
		}
	}

	public double calculateAverageRateOfReturn() {
		Double ARR = 0.0;
		for (int i=0; i<Accounts.size(); i++) {
			ARR = ARR + (Accounts.get(i).getInterestRate())*Accounts.get(i).getBalance();
		}
		ARR = ARR/(totalWealth);
		System.out.println("Your average rate of return across all accounts is: " +  ARR);
		return ARR;
	}

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