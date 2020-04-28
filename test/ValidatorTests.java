import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Account.Account;
import Account.Client;
import FinancialAdvisor.FinancialAdvisor;
import Validator.Validator;

public class ValidatorTests {
	@Test
	public void testValidateAccountNumberBadAccountNumber() {
		String accountNumber = "alskdjf;awiejf";
		boolean result = Validator.validateAccountNumber(accountNumber);
		assertFalse("Should have returned false because it is not a valid account number", result);
	}
	@Test
	public void testValidateAccountNumberGoodAccountNumber() {
		String accountNumber = "12345678";
		boolean result = Validator.validateAccountNumber(accountNumber);
		assertTrue("Should have returned true because it is a valid account number", result);
	}
	
	
	@Test
	public void testValidateTransactionAmountBadAmount() {
		String transactionAmount = "alskdjf;awiejf";
		boolean result = Validator.validateTransactionAmount(transactionAmount);
		assertFalse("Should have returned false because it is not a valid transaction amount", result);
	}
	@Test
	public void testValidateTransactionAmountGoodAmount() {
		String transactionAmount = "999";
		boolean result = Validator.validateTransactionAmount(transactionAmount);
		assertTrue("Should have returned true because it is a valid transaction amount", result);
	}
	
	
	@Test
	public void testValidateAccountTypeBadAccountType() {
		String accountType = "alskdjf;awiejf";
		boolean result = Validator.validateAccountType(accountType);
		assertFalse("Should have returned false because it is not a valid account type", result);
	}
	
	@Test
	public void testValidateAccountTypeGoodAccountType() {
		String accountType = "checkings";
		boolean result = Validator.validateAccountType(accountType);
		assertTrue("Should have returned true because it is a valid account type", result);
	}
}
