package CodingHire.StringAndArray;

/*A palindromic number is a number that remains the same when its digits are reversed.*/

public class A150_PalindromeNumber {

	public static void main(String[] args) {
		
		boolean result = palindromic(151);
		
		System.out.println(result);
	}

	private static boolean palindromic(int num) {


		String numString = String.valueOf(num);
		char[] chars = numString.toCharArray();
		
		for (int i = 0; i < (chars.length / 2); i++) {
			if (chars[i] != chars[chars.length - i - 1]) {
				return false;
			}
		}
				
		return true;
		
	}
}
