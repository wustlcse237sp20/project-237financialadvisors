import static org.junit.Assert.*;

import org.junit.Test;

import Account.Account;

public class AccountTests {

	@Test
	public void testWithdraw() {
		Account a = new Account("Saving", "Chase", 0.1, 500.0);
		//allowed to overdraw 500
		assertTrue(a.withdraw(500.0));
		assertFalse(a.withdraw(1.0));
		a.deposit(1000.0);
		double[] withdrawAmounts = {2.0, -5.0, 600.0, 2000.0};
		boolean [] withdrawSuccess = {true, false, true, false};
		for(int i=0;i<withdrawAmounts.length; i++) {
			assertEquals(withdrawSuccess[i], a.withdraw(withdrawAmounts[i]));
		}
	}
	
	@Test
	public void testDeposit() {
		Account b = new Account("Checking", "Bank of America", 0.0, 25.0);
		b.deposit(1000.0);
		assertTrue(b.deposit(100.0));
		assertFalse(b.deposit(-100.0));
		
	}

}
