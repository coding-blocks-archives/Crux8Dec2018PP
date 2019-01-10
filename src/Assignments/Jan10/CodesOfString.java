package Assignments.Jan10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class CodesOfString {

	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		codes(str, "");
		// System.out.println(list);
		
		System.out.println(codesAL(str));
	}

	public static void codes(String ques, String ans) {

		if (ques.length() == 0) {
			// System.out.println(ans);
			list.add(ans);
			return;
		}

		String roq1 = ques.substring(1);
		String ch1str = ques.substring(0, 1);
		int ch1int = Integer.parseInt(ch1str);
		char ch1char = (char) (ch1int + 96);

		codes(roq1, ans + ch1char);

		if (ques.length() >= 2) {

			String roq2 = ques.substring(2);
			String ch2str = ques.substring(0, 2);

			int ch2int = Integer.parseInt(ch2str);
			char ch2char = (char) (ch2int + 96);

			if (ch2int <= 26)
				codes(roq2, ans + ch2char);

		}

	}

	public static ArrayList<String> codesAL(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		String roq1 = ques.substring(1);
		String ch1str = ques.substring(0, 1);
		int ch1int = Integer.parseInt(ch1str);
		char ch1char = (char) (ch1int + 96);

		ArrayList<String> rr1 = codesAL(roq1);

		for (String rrs : rr1) {
			mr.add(ch1char + rrs);
		}

		if (ques.length() >= 2) {

			String roq2 = ques.substring(2);
			String ch2str = ques.substring(0, 2);

			int ch2int = Integer.parseInt(ch2str);
			char ch2char = (char) (ch2int + 96);

			if (ch2int <= 26) {
				ArrayList<String> rr2 = codesAL(roq2);

				for (String rrs : rr2) {
					mr.add(ch2char + rrs);
				}

			}

		}

		return mr;
	}

}
