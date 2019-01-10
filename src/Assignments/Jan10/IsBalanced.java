package Assignments.Jan10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class IsBalanced {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String str = scn.next();
		System.out.println(balanced(str, ""));

	}

	public static boolean balanced(String ques, String ans) {

		if (ques.length() == 0) {
			if (ans.length() == 0) {
				return true;
			} else { // opening > closing
				return false;
			}
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (ch == '(' || ch == '{' || ch == '[') {
			return balanced(roq, ans + ch);
		} else if (ch == ')' || ch == '}' || ch == ']') {

			// closing > opening
			if (ans.length() == 0) {
				return false;
			}

			char lastchar = ans.charAt(ans.length() - 1);

			if ((ch == ')' && lastchar == '(') || (ch == '}' && lastchar == '{') || (ch == ']' && lastchar == '[')) {
				return balanced(roq, ans.substring(0, ans.length() - 1));
			} else {
				return false;
			}
		} else {
			return balanced(roq, ans);
		}

	}

}
