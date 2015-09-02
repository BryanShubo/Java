package CodingHire.StringAndArray;

/*if we make the two string into rings,the two rings are the same. 
 Example:"abcd" and "cdab" are isomorphic ”abcd“ and "dcba" are not isomrphic "cdab" and "abdc" are not too.*/

public class A003_IsomorphicStrings {

	public static void main(String[] args) {

		String str1 = "abcd";
		String str2 = "cdab";
		boolean result = isomorphic(str1, str2);
		System.out.println(result);
	}

	private static boolean isomorphic(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}
		if (str1.equals(str2)) {
			return true;
		}

		char first = str1.charAt(0);
		int firstPos = str2.indexOf(first);

		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();

		for (int i = firstPos; i < c2.length; i++) {
			if (c2[i] != c1[i - firstPos]) {
				return false;
			}
		}

		for (int i = 0; i < firstPos; i++) {
			if (c2[i] != c1[i + firstPos]) {
				return false;
			}
		}

		return true;

	}

}
