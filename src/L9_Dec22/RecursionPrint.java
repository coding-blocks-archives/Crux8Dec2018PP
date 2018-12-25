package L9_Dec22;

import java.util.ArrayList;

import L7_Dec19.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Dec-2018
 *
 */

public class RecursionPrint {

	public static void main(String[] args) {

		// printSS("abc", "");
		// printKPC("145", "");
		// printPermutation2("aac", "");
		// permutationNoDuplicates("aba", "");
		// permutationNoDuplicates2("aba", "");
		// coinToss(3, "");
		// coinTossNoConsecutiveHead(3, "", false);

		// System.out.println(boardPath(0, 10, ""));
		// int count = 0;
		// System.out.println(mazePath(0, 0, 2, 2, ""));
		// System.out.println(mazePathDMM(0, 0, 2, 2, ""));

		// lexicoCounting(0, 1000);

		// generateParenthesis(3, "", 0, 0);
		System.out.println(wildCardMatching("abcc", "a*?"));
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes
	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}
	}

	public static void printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {
			printPermutation(roq, ans.substring(0, i) + ch + ans.substring(i));
		}

	}

	public static void printPermutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			printPermutation2(roq, ans + ch);
		}

	}

	public static void permutationNoDuplicates(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			boolean flag = true;
			char ch = ques.charAt(i);

			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				String roq = ques.substring(0, i) + ques.substring(i + 1);
				permutationNoDuplicates(roq, ans + ch);
			}
		}

	}

	public static void permutationNoDuplicates2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] visited = new boolean[256];
		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);

			if (visited[ch]) {
				continue;
			}

			String roq = ques.substring(0, i) + ques.substring(i + 1);
			permutationNoDuplicates2(roq, ans + ch);
			visited[ch] = true;
		}

	}

	public static void coinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");

	}

	public static void coinTossNoConsecutiveHead(int n, String ans, boolean wasLastHeadIncluded) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (wasLastHeadIncluded) {
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		} else {

			coinTossNoConsecutiveHead(n - 1, ans + "H", true);
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		}
	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += boardPath(curr + dice, end, ans + dice);
		}

		return count;

	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr + 1, cc, er, ec, ans + "V");
		int cv = mazePath(cr, cc + 1, er, ec, ans + "H");

		return ch + cv;
	}

	public static int mazePathDMM(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		for (int jump = 1; cr + jump <= er; jump++) {
			count += mazePathDMM(cr + jump, cc, er, ec, ans + "V" + jump);
		}

		for (int jump = 1; cc + jump <= ec; jump++) {
			count += mazePathDMM(cr, cc + jump, er, ec, ans + "H" + jump);
		}

		for (int jump = 1; cc + jump <= ec && cr + jump <= er; jump++) {
			count += mazePathDMM(cr + jump, cc + jump, er, ec, ans + "D" + jump);
		}

		return count;
	}

	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;
		if (curr == 0) {
			i = 1;
		}

		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, end);
		}

	}

	public static void generateParenthesis(int n, String ans, int open, int close) {

		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}

		if (open > n || close > n || close > open) {
			return;
		}

		generateParenthesis(n, ans + ")", open, close + 1);
		generateParenthesis(n, ans + "(", open + 1, close);

	}

	public static boolean wildCardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pattern.length() != 0) {

			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		char srcch = src.charAt(0);
		char patch = pattern.charAt(0);

		String srcros = src.substring(1);
		String patros = pattern.substring(1);

		boolean rr;
		if (srcch == patch || patch == '?') {
			rr = wildCardMatching(srcros, patros);
		} else if (patch == '*') {
			rr = wildCardMatching(src, patros) || wildCardMatching(srcros, pattern);
		} else {
			rr = false;
		}

		return rr;

	}

}
