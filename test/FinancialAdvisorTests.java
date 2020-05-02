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
		FinancialAdvisor f = new FinancialAdvisor(client);
		
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
		assertTrue(Accounts.size() == 2);
		assertTrue(c.getBalance() == 200.0);
		
	}
	
	@Test
	public void testConsolidateAccountsFail() {
		List<Account> Accounts = new ArrayList<Account>();
		Client client = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor(client);
		
		Account a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		Accounts.add(b);
		Account c = new Account("savings", "chase", 0.5, 500.0, 28374958);
		Accounts.add(c);
		f.consolidateAccounts(client);
		assertFalse(Accounts.size() == 3);
	}

	@Test
	public void testOptimalRiskByAgeBracket() {
		List<Account> Accounts = new ArrayList<Account>();
		Client c = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor(c);
		assertEquals(12.0, f.optimalRiskByAgeBracket(c), 0);
	}

	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testRecommendHigherYieldAccounts() {
		List<Account> Accounts = new ArrayList<Account>();
		Client client = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor(client);
		
		Account a = new Account("savings", "chase", 2.0, 500.0, 12345678);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		Accounts.add(b);
		
		//Prepare to redirect output
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		f.recommendHigherYieldAccounts(client);
		assertEquals("Consider opening a Capital One 360 Checking account for a higher yield of 0.20% APY", os.toString());
		os.reset();
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
	}
}
