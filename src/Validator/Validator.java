package Validator;

import java.util.regex.Pattern;

public class Validator {

	/**
	 * Simple regex to check for a 8 digit account number
	 * @param account number
	 * @return
	 */
	public static boolean validateAccountNumber(String accountNumber) {
		return Pattern.matches("^\\d{8}$", accountNumber);
	}
	
	/**
	 * Simple regex to check transaction amount is a double
	 * @param transaction amount
	 * @return
	 */
	public static boolean validateTransactionAmount(String transactionAmount) {
		return Pattern.matches("^(0|[1-9]\\d*)(\\.\\d+)?$", transactionAmount);
	}
	
	/**
	 * Simple regex to check for string input of account type
	 * @param account type
	 * @return
	 */
	public static boolean validateAccountType(String accountType) {
		return Pattern.matches("(checkings|savings|stocks|bonds)", accountType);
	}
}
