package Assignments.Jan10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class LexicoLarger {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		// permutation(str, "", str);
		permutation(str, "", false);

	}

	public static void permutation(String ques, String ans, String os) {

		if (ques.length() == 0) {
			if (ans.compareTo(os) > 0)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			permutation(roq, ans + ch, os);
		}

	}

	public static void permutation(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {
			if (isLarger)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				permutation(roq, ans + ch, true);
			} else {
				if (ch < ques.charAt(0)) {
					// no call
				} else if (ch > ques.charAt(0)) {
					permutation(roq, ans + ch, true);
				} else {
					permutation(roq, ans + ch, false);
				}
			}
		}

	}

}
