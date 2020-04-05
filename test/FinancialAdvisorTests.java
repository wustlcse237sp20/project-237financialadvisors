import static org.junit.Assert.*;

import org.junit.Test;

public class FinancialAdvisorTests {

	@Test
	public void testConsolidateAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testOptimalRiskByAgeBracket() {
		Client c = new Client(30);
		assertTrue(c.optimalRiskByAgeBracket(5.0));
		assertFalse(c.optimalRiskByAgeBracket(15.0));
	}
}
