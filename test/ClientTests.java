import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Account.Account;
import Account.Client;

public class ClientTests {
	List<Account> Accounts;
	Account a;
	Account b;
	Account c;
	Account d;
	Account e;
	Client one;
	
	@Before
	public void setUp() {
		Accounts = new ArrayList<Account>();
		a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		a.deposit(500.0);
		Accounts.add(a);
		b = new Account("checkings", "boa", 0.0, 100.0, 87654321);
		b.deposit(300.0);
		Accounts.add(b);
		c = new Account("investments", "fidelity", 7.0, 0.0, 56781234);
		c.deposit(700.0);
		Accounts.add(c);
		d = new Account("bonds", "etrade", 3.0, 0.0, 43218765);
		d.deposit(300.0);
		Accounts.add(d);
		e = new Account("investments", "etrade", 8.0, 0.0, 34561278);
		e.deposit(200.0);
		Accounts.add(e);
		one = new Client(Accounts, 27);
		
	}

	@Test
	public void testGetTotalWealth() {
		assertTrue(one.getTotalWealth() == 2000.0);
	}
	
	@Test
	public void testGetAverageRateOfReturn() {
		System.out.println("Value: " + one.getAverageRateOfReturn());
		assertTrue(one.getAverageRateOfReturn() == 3.75);
	}

	
	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testCalculatePercentagesByAccount() {
		//Prepare to redirect output
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		one.calculatePercentagesByAccount();
		assertEquals("25.0% of your wealth is in account 1, 15.0% of your wealth is in account 2, 35.0% of your wealth is in account 3, 15.0% of your wealth is in account 4, 10.0% of your wealth is in account 5, ", os.toString());
		os.reset();
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
	}
	
	@Test
	public void testTransferMoney() {
		one.transferMoney(12345678, 87654321, 100.0);
		assertTrue(a.getBalance()==400.0);
		assertTrue(b.getBalance()==400.0);
	}
	
	@Test
	public void testDeleteAccount() {
		one.deleteAccount(34561278);
		assertTrue(Accounts.size()==4);
	}
	
	@Test
	public void testDeposit() {
		one.deposit(12345678, 200);
		assertTrue(a.getBalance()==700.0);
	}
	
	@Test
	public void testWithdraw() {
		one.withdraw(12345678, 200);
		assertTrue(a.getBalance()==300.0);
	}
	
	public void testInterestRateCalculator() {
		one.interestRateCalculator(one, 5, 12);
		assertTrue(one.getTotalWealth() == 2411.76);
	}

	public void testNumberOfATypeOfAccount() {
		assertEquals(2, one.numberOfATypeOfAccount(one, "investments"));
		assertEquals(1, one.numberOfATypeOfAccount(one, "savings"));
		assertEquals(1, one.numberOfATypeOfAccount(one, "checkings"));
		assertEquals(1, one.numberOfATypeOfAccount(one, "bonds"));
	}
	
	@Test
	public void testFindHighestInterestRate() {
		assertTrue(one.findHighestInterestRate(one.getAccounts()) == e);
	}
	
}
