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
		return Pattern.matches("([1-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9]|[1-8][0-9]{3}|9[0-8][0-9]{2}|99[0-8][0-9]|999[0-9]|10000)", transactionAmount);
	}
	
	/**
	 * Simple regex to check for string input of account type
	 * @param account type
	 * @return
	 */
	public static boolean validateAccountType(String accountType) {
		return Pattern.matches("\b(checkings|savings|stocks|bonds)\b", accountType);
	}
}
