import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import FinancialAdvisor.FinancialAdvisor;
import Account.Account;
import Account.Client;

public class FinancialAdvisorTests {

	@Test
	public void testConsolidateAccountsSuccess() {
		List<Account> Accounts = new ArrayList<Account>();
		Client client = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor();
		
		Account a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		a.deposit(100.0);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		b.deposit(100.0);
		Accounts.add(b);
		Account c = new Account("savings", "chase", 0.5, 500.0, 28374958);
		c.deposit(0.0);
		Accounts.add(c);
		f.consolidateAccounts(client);
		assertTrue(Accounts.size() == 2);
		assertTrue(c.getBalance() == 100.0);
		assertTrue(b.getBalance() == 100.0);
	}
	
	@Test
	public void testConsolidateAccountsFail() {
		List<Account> Accounts = new ArrayList<Account>();
		Client client = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor();
		
		Account a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		a.deposit(100.0);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		b.deposit(100.0);
		Accounts.add(b);
		Account c = new Account("savings", "chase", 0.5, 500.0, 28374958);
		c.deposit(100.0);
		Accounts.add(c);
		f.consolidateAccounts(client);
		assertFalse(Accounts.size() == 3);
		assertFalse(c.getBalance() == 100.0);
	}

	@Test
	public void testOptimalRiskByAgeBracket() {
		List<Account> Accounts = new ArrayList<Account>();
		Client c = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor();
		Account a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		a.deposit(10.0);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		a.deposit(10.0);
		Accounts.add(b);
		
		assertEquals("Your current ARR is: 0.2%, which is less than the optimal ARR of 12.0% for your age bracket.", f.optimalRiskByAgeBracket(c));
	}

	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testRecommendHigherYieldAccounts() {
		List<Account> Accounts = new ArrayList<Account>();
		Client client = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor();
		
		Account a = new Account("savings", "chase", 2.0, 500.0, 12345678);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		Accounts.add(b);
		
		String output = f.recommendHigherYieldAccounts(client);
		assertEquals("Recommendation for Account #12345678: No higher yield recommendation. \nRecommendation for Account #99876554: Consider opening a Capital One 360 Checking account for a higher yield of 0.20% APY. \n", output);
	}
}
