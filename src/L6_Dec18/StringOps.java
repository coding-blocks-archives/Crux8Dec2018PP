package L6_Dec18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Dec-2018
 *
 */

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		printChars(str);
		System.out.println(str);

		substrings(str);
		System.out.println(isPalindrome(str));
		System.out.println(countPalindromicSS(str));
		System.out.println(reverse("23/45-789"));

		appendString();
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

	}

	public static void substrings(String str) {

		for (int si = 0; si < str.length(); si++) {
			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				System.out.println(ss);

			}
		}

	}

	public static boolean isPalindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;

	}

	public static int countPalindromicSS(String str) {

		int count = 0;

		for (int si = 0; si < str.length(); si++) {
			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				if (isPalindrome(ss))
					count++;

			}
		}

		return count;
	}

	public static String reverse(String str) {

		String subans = "";
		String ans = "";

		for (int i = str.length() - 1; i >= 0; i--) {

			char ch = str.charAt(i);

			if (Character.isDigit(ch)) {
				subans = ch + subans;
			} else {
				ans = ans + subans + ch;
				subans = "";
			}

		}

		ans += subans;
		return ans;

	}

	public static void appendString() {

		long start = System.currentTimeMillis();

		int n = 100000;
		// String str = "";
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			// str += i;
			sb.append(i);
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
