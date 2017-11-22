package fileVisitors.util;

public class StringHelper {
	

	/**
	 * Check if the word is a Palindrome
	 * @param str
	 * @return <b>true</b> if word is palindrome else  <b>false</b>
 	 */
	public static boolean isPalindrome(String str) {
		int j = str.length() - 1;
		int i = 0;

		while(j > i) {
			char charAti = str.toLowerCase().charAt(i);
			char charAtj = str.toLowerCase().charAt(j);

			if(charAti != charAtj) {
				return false;
			}

			i += 1;
			j -= 1;

		}
		return true;

	}
	

	/**
	 * Check if string is of prime length
	 * @param str
	 * @return <b>true</b> if prime length string else <b>false</b>
	 */
	public static boolean isPrimeLength(String str) {

		int length = str.length();

		if(length <= 1) return false;

		for (int i = 2; i < length; i++) {
			if (length % i == 0) {
				return false;
			}
		}

		return true;

	}


}
