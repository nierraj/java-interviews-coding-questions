package com.neeraj.codingproblems;

public class LuhnAlgorithm {

	static boolean validate(String cardNo) {
		int digits = cardNo.length();

		int sum = 0;
		boolean isSecond = false;
		//Step 1 - Starting from the rightmost digit double the value of every second digit
		for (int i = digits - 1; i >= 0; i--) {

			int d = cardNo.charAt(i) - '0';

			if (isSecond == true)
				d = d * 2;

			// Step 2 - If doubling of a number results in a two digits number i.e greater than 9(e.g., 6 * 2 = 12), 
			// then add the digits of the product (e.g., 12: 1 + 2 = 3, 15: 1 + 5 = 6), to get a single digit number. 
			// We add two digits to handle
			// cases that make two digits
			// after doubling
			sum += d / 10;
			sum += d % 10;

			isSecond = !isSecond;
		}
		// If the total modulo 10 is equal to 0 (if the total ends in zero) then the number is valid according to the Luhn formula; else it is not valid.
		return (sum % 10 == 0);
	}

	static public void main(String[] args) {
		String cardNo = "79927398713";
		if (validate(cardNo))
			System.out.println("This is a valid card");
		else
			System.out.println("This is not a valid card");

	}
}
