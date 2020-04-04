package interestRate;

import java.util.ArrayList;

public class InterestRate {
 
	
	public void interestRateCalculator (double accountBalance, double interestRate, int years) {
		
		double principalBalance = accountBalance;
		
		for (int i = 0; i < years; i++){ 
			
			accountBalance = principalBalance * Math.pow((1 + interestRate), years);		
		}
		
		
	}
	
}
