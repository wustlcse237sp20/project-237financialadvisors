package interestRate;

import java.util.ArrayList;

public class InterestRate {
 
	
	public void interestRateCalculator (double accountBalance, double interestRate, int years) {
		
		for (int i = 0; i < years; i++){ 
			
			accountBalance = accountBalance * (1 + interestRate);		
		}
		
		
	}
	
}
