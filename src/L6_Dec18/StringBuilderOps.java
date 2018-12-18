package L6_Dec18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Dec-2018
 *
 */

public class StringBuilderOps {

	public static void main(String[] args) {

		System.out.println(toggleCase("AcDghi"));
		System.out.println(lowerHigherAscii("gbdx"));

	}

	public static String toggleCase(String str) {

		StringBuilder ans = new StringBuilder();

		int diff = 'a' - 'A';

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {
				ans.append((char) (ch + diff));
			} else if (Character.isLowerCase(ch)) {
				ans.append((char) (ch - diff));
			}
		}

		return ans.toString();

	}

	public static String lowerHigherAscii(String str) {

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (i % 2 == 0) {
				ch = (char) (ch - 1);
				ans.append(ch);

			} else {
				ch++;
				ans.append(ch);
			}

		}
		return ans.toString();

	}

}
