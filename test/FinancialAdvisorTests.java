import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import FinancialAdvisor.FinancialAdvisor;
import Account.Account;
import Account.Client;

public class FinancialAdvisorTests {

	@Test
	public void testConsolidateAccounts() {
		List<Account> Accounts = new ArrayList<Account>();
		Account a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		Accounts.add(a);
		Account b = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		Accounts.add(b);
		Account c = new Account("savings", "chase", 0.5, 500.0, 28374958);
		Accounts.add(c);
		Client client = new Client(Accounts, 30);
		
		FinancialAdvisor f = new FinancialAdvisor(client);
		f.consolidateAccounts(client);
		
		List<Account> x = new ArrayList<Account>();
		Account y = new Account("checkings", "boa", 0.0, 100.0, 99876554);
		Accounts.add(y);
		Account z = new Account("savings", "chase", 0.5, 500.0, 28374958);
		Accounts.add(z);
		Client m = new Client(x, 30);
		
		
		assertTrue(client.getAccounts().size() == m.getAccounts().size());
	}

	@Test
	public void testOptimalRiskByAgeBracket() {
		List<Account> Accounts = new ArrayList<Account>();
		Client c = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor(c);
		assertEquals(10.0, f.optimalRiskByAgeBracket(c), 0);
	}
}
