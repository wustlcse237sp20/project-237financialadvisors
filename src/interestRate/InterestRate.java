package interestRate;

import java.util.ArrayList;

public class InterestRate {
 
	/**
	 * 
	 * @param accountBalance balance in the account in question
	 * @param interestRate interest rate for account
	 * @param years number of years for which interest rate is applied
	 * @param compoundPerYear number of times interest rate is applied per year
	 */
	public void interestRateCalculator (double accountBalance, double interestRate, int years, int compoundPerYear) {
		
		double principalBalance = accountBalance;
		
		for (int i = 0; i < years; i++){ 
			
			accountBalance = principalBalance * Math.pow((1 + (interestRate/compoundPerYear)), years);		
		}
		
	}
	
}
