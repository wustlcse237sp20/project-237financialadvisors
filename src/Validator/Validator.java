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
	 * @param account number
	 * @return
	 */
	public static boolean validateTransactionAmount(String transactionAmount) {
		return Pattern.matches("^\\d{3}$", transactionAmount);
	}
}
