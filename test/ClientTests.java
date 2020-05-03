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
	List<Account> Account1;
	Account a;
	Account b;
	Account c;
	Account d;
	Account e;
	Client one;
	List<Account> Account2;
	Account f;
	Account g;
	Account h;
	Account i;
	Account j;
	Client two;

	@Before
	public void setUp() {
		Account1 = new ArrayList<Account>();
		a = new Account("savings", "chase", 0.2, 500.0, 12345678);
		a.deposit(500.0);
		Account1.add(a);
		b = new Account("checkings", "boa", 0.0, 100.0, 87654321);
		b.deposit(300.0);
		Account1.add(b);
		c = new Account("investments", "fidelity", 7.0, 0.0, 56781234);
		c.deposit(700.0);
		Account1.add(c);
		d = new Account("bonds", "etrade", 3.0, 0.0, 43218765);
		d.deposit(300.0);
		Account1.add(d);
		e = new Account("investments", "etrade", 8.0, 0.0, 34561278);
		e.deposit(200.0);
		Account1.add(e);
		one = new Client(Account1, 27);

		Account2 = new ArrayList<Account>();
		f = new Account("savings", "capitalone", 1.7, 300.0, 987654321);
		f.deposit(1200.0);
		Account2.add(f);
		g = new Account("savings", "chase", 0.2, 800.0, 987644321);
		g.deposit(2200.0);
		Account2.add(g);
		h = new Account("investment", "TD", 7.0, 0.0, 487654321);
		h.deposit(405.0);
		Account2.add(h);
		i = new Account("checkings", "citi", 0.1, 300.0, 987654321);
		i.deposit(8097.66);
		Account2.add(i);
		j = new Account("savings", "ally", 2.0, 300.0, 987654321);
		j.deposit(4563.0);
		Account2.add(j);
		two = new Client(Account2, 55);

	}

	@Test
	public void testAddAccount() {
		Account x = new Account("savings", "ally", 1.0, 250.0, 76584321);
		one.addAccount(x);
		assertTrue(Account1.size() == 6);
		Account y = new Account("checkings", "fidelity", 0.0, 2500.0, 87623912);
		two.addAccount(y);
		assertTrue(Account2.size() == 6);
	}
	
	@Test
	public void testDuplicateAccountNumber() {
		assertFalse(one.duplicateAccountNumber(one, 12345678));
	}

	@Test
	public void testDeleteAccount() {
		one.deleteAccount(34561278);
		assertTrue(Account1.size()==4);
	}

	@Test
	public void testDeleteNonexistantAccount() {
		assertFalse(one.deleteAccount(547392834));
		assertTrue(Account1.size()==5); 
		assertFalse(Account1.size()==4);
	}

	//deposit and withdraw tested additionally in accountTests (negative amount, overdraw, zero etc.)
	@Test
	public void testDeposit() {
		one.deposit(12345678, 200.0);
		assertTrue(a.getBalance()==700.0);
	}

	@Test
	public void testDepositNonexistantAccount() {
		two.deposit(192834719, 150.0);
		//make sure $150 wasn't added to any account in Client two 
		assertFalse(f.getBalance()==1350.0);
		assertFalse(g.getBalance()==2350.0);
		assertFalse(h.getBalance()==555.0);
		assertFalse(i.getBalance()==8247.66);
		assertFalse(j.getBalance()==4713.0);
	}

	@Test
	public void testWithdraw() {
		one.withdraw(12345678, 200.0);
		assertTrue(a.getBalance()==300.0);
	}

	@Test
	public void testWithdrawNonexistantAccount() {
		two.withdraw(192834719, 150.0);
		//make sure $150 wasn't added to any account in Client two 
		assertFalse(f.getBalance()==1050.0);
		assertFalse(g.getBalance()==2050.0);
		assertFalse(h.getBalance()==255.0);
		assertFalse(i.getBalance()==7947.66);
		assertFalse(j.getBalance()==4413.0);
	}

	@Test
	public void testTransferMoney() {
		one.transferMoney(12345678, 87654321, 100.0);
		assertTrue(a.getBalance()==400.0);
		assertTrue(b.getBalance()==400.0);
	}

	@Test
	public void testTransferMoneyNegative() {
		assertFalse(one.transferMoney(12345678, 87654321, -100.0));
	}

	@Test
	public void testTransferMoneyNonexistantAccount() {
		assertFalse(one.transferMoney(123456789, 87654321, 100.0));
		assertFalse(one.transferMoney(12345678, 876543210, 100.0));
	}

	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testGenerateAccounts() {
		//Prepare to redirect output
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		one.generateAccounts();
		String accountList = "Account 1:" + "\n" + "Account Type: savings, chase, Account #: 12345678, Balance: 500.0, Interest Rate: 0.2, Amount allowed to overdraw: 500.0" + "\n" + "Account 2:" + "\n" + "Account Type: checkings, boa, Account #: 87654321, Balance: 300.0, Interest Rate: 0.0, Amount allowed to overdraw: 100.0" + "\n" + "Account 3:" + "\n" + "Account Type: investments, fidelity, Account #: 56781234, Balance: 700.0, Interest Rate: 7.0, Amount allowed to overdraw: 0.0" + "\n" + "Account 4:" + "\n" +"Account Type: bonds, etrade, Account #: 43218765, Balance: 300.0, Interest Rate: 3.0, Amount allowed to overdraw: 0.0" + "\n" + "Account 5:" + "\n" + "Account Type: investments, etrade, Account #: 34561278, Balance: 200.0, Interest Rate: 8.0, Amount allowed to overdraw: 0.0" + "\n";
		assertEquals(accountList, os.toString());
		os.reset();
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
	}

	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testCalculatePercentagesByAccount() {
		//Prepare to redirect output
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		one.calculatePercentagesByAccount(one);
		assertEquals("25.0% of your wealth is in account # 1, 15.0% of your wealth is in account # 2, 35.0% of your wealth is in account # 3, 15.0% of your wealth is in account # 4, 10.0% of your wealth is in account # 5, ", os.toString());
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
	public void testCalculateTotalWealth() {
		assertTrue(one.getTotalWealth() == 2000.0);
		assertTrue(two.getTotalWealth() == 16465.66);

	}

	@Test
	public void testCalculateAverageRateOfReturn() {
		assertTrue(one.getAverageRateOfReturn() == 3.75);
		assertTrue(two.getAverageRateOfReturn() == 0.93);
	}

	@Test
	public void testNumberOfATypeOfAccount() {
		assertEquals(2, one.numberOfATypeOfAccount(one, "investments"));
		assertEquals(1, one.numberOfATypeOfAccount(one, "savings"));
		assertEquals(1, one.numberOfATypeOfAccount(one, "checkings"));
		assertEquals(1, one.numberOfATypeOfAccount(one, "bonds"));
	}

	@Test
	public void testFindHighestInterestRate() {
		assertTrue(one.findHighestInterestRate(one.getAccounts()) == e);
		assertTrue(two.findHighestInterestRate(two.getAccounts()) == h);
	}
	
	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testInterestRateCalculator() {
		//Prepare to redirect output
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		one.interestRateCalculator(one, 5, 12);
		assertEquals("In 5 years you will have: $2411.76" + "\n", os.toString());
		os.reset();
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
	}
	
	//output stream code from https://limzhenghong.wordpress.com/2015/03/18/junit-with-system-out-println/
	@Test
	public void testInterestRateCalculatorNegativeComponent() {
		//Prepare to redirect output
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		one.interestRateCalculator(one, -5, 12);
		assertEquals("Enter appropriate inputs", os.toString());
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
