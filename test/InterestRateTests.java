import static org.junit.Assert.*;

import interestRate.InterestRate;

import org.junit.Test;

import Account.Account;

public class InterestRateTests {

	@Test
	public void testInterestRateCalculator() {
		Account testAccount = new Account("Checking", "Chase", 0.1, 500.0, 12345678);
		testAccount.deposit(100.0);
		interestRateCalculator(testAccount);
		assertTrue(accountBalance(103.333333));
	}
}
