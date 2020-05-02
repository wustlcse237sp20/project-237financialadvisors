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
	public void testValidateDoubleInputBadDouble() {
		String doubleInput = "999.999";
		boolean result = Validator.validateDoubleInput(doubleInput);
		assertFalse("Should have returned false because it is not a valid double with at most 2 decimals", result);
	}
	@Test
	public void testValidateDoubleInputGoodDouble() {
		String doubleInput = "999.99";
		boolean result = Validator.validateDoubleInput(doubleInput);
		assertTrue("Should have returned true because it is a valid double with at most 2 decimals", result);
	}
	
	@Test
	public void testValidateIntInputBadInt() {
		String intInput = "999.999";
		boolean result = Validator.validateIntInput(intInput);
		assertFalse("Should have returned false because it is not a valid int", result);
	}
	@Test
	public void testValidateIntInputGoodInt() {
		String intInput = "999";
		boolean result = Validator.validateIntInput(intInput);
		assertTrue("Should have returned true because it is a valid int", result);
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
