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
		fail("Not yet implemented");
	}

	@Test
	public void testOptimalRiskByAgeBracket() {
		List<Account> Accounts = new ArrayList<Account>();
		Client c = new Client(Accounts, 30);
		FinancialAdvisor f = new FinancialAdvisor(c);
		assertEquals(10.0, f.optimalRiskByAgeBracket(c), 0);
	}
}
