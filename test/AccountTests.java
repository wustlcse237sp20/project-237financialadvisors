import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Account.Account;

public class AccountTests {
	Account a;
	Account b;
	Account c;
	
	@Before
	public void setUp() {
		a = new Account("Saving", "Chase", 0.1, 500.0, 12345678);
		a.deposit(1000.0);
		b = new Account("Checking", "Bank of America", 0.0, 25.0, 87654321);
		b.deposit(1000.0);
		c = new Account("Investment", "Fidelity", 7.0, 300.0, 48471234);
	}
	
	@Test
	public void testWithdrawSuccess() {
		assertTrue(a.withdraw(2.0));
		assertTrue(a.withdraw(100.5));
		
	}
	
	@Test
	public void testWithdrawNegativeAmount() {
		assertFalse(a.withdraw(-5.0));
		assertFalse(a.withdraw(-100.0));
	}
	
	@Test
	public void testWithdrawOverdrawAllowed() {
		assertTrue(a.withdraw(600.0));
		assertTrue(c.withdraw(300.0));
	}
	
	@Test
	public void testWithdrawOverdrawFailure() {
		assertFalse(a.withdraw(2000.0));
		assertFalse(c.withdraw(400.0));
	}
	
	@Test
	public void testWithdrawZero() {
		assertFalse(a.withdraw(0.0));
	}
	
	@Test
	public void testDepositSuccess() {
		assertTrue(b.deposit(100.0));
	}
	
	@Test
	public void testDepositZero() {
		assertFalse(c.deposit(0.0));
	}
	
	@Test
	public void testDepositFailure() {
		assertFalse(b.deposit(-100.0));
		assertFalse(c.deposit(-12.46));
	}	

}
