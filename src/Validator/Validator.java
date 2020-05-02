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
	 * Simple regex to check if a number is a double with 2 decimals
	 * @param doubleInput
	 * @return
	 */
	public static boolean validateDoubleInput(String doubleInput) {
		return Pattern.matches("^[0-9]+(\\.[0-9]{1,2})?$", doubleInput);
	}
	
	/**
	 * Simple regex to check if a number is an int (no decimals)
	 * @param intInput
	 * @return
	 */
	public static boolean validateIntInput(String intInput) {
		return Pattern.matches("^\\d+$", intInput);
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
