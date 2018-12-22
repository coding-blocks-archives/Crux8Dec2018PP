package L7_Dec19;

import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Dec-2018
 *
 */

public class RecursionGet {

	public static void main(String[] args) {

		// String str = " ";
		// System.out.println(str.length());
		//
		// ArrayList<String> list = new ArrayList<>();
		// System.out.println(list.size());
		//
		// list.add(str);
		// System.out.println(list.size());

		// System.out.println(getSS("abc"));

		// System.out.println(getKPC("145").size());

		ArrayList<ArrayList<String>> list = new ArrayList<>();

		ArrayList<String> a1 = new ArrayList<>();
		a1.add("abc");
		a1.add("def");
		list.add(a1);
		System.out.println(list.size());
		System.out.println(list.get(0).get(1));

		// System.out.println(getPermutation("abc"));
		// System.out.println(getBoardPath(0, 10));
		System.out.println(getMazePathD(0, 0, 2, 2).size());
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {

			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recRes = getSS(ros);

		ArrayList<String> myRes = new ArrayList<>();

		for (String val : recRes) {
			myRes.add(val);
			myRes.add(ch + val);

		}

		return myRes;

	}

	public static ArrayList<String> getSSAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recRes = getSSAscii(ros);

		ArrayList<String> myRes = new ArrayList<>();

		for (String val : recRes) {
			myRes.add(val); // no
			myRes.add(ch + val); // char
			myRes.add((int) ch + val); // ascii

		}

		return myRes;
	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {

			for (String val : rr) {
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}

		// for (int i = 0; i < str.length(); i++) {
		// for (String val : rr) {
		//
		// mr.add(val.substring(0, i) + ch + val.substring(i));
		// }
		// }

		return mr;
	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr >= end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(curr + dice, end);
			for (String val : rr) {
				mr.add(dice + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		return mr;

	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec);

		for (String val : rrd) {
			mr.add("D" + val);
		}

		return mr;

	}

	public static ArrayList<String> getMazePathDMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int jump = 1; cr + jump <= er; jump++) {
			ArrayList<String> rrv = getMazePathDMM(cr + jump, cc, er, ec);

			for (String val : rrv) {
				mr.add("V" + jump + val);
			}
		}

		for (int jump = 1; cc + jump <= ec; jump++) {
			ArrayList<String> rrh = getMazePathDMM(cr, cc + jump, er, ec);

			for (String val : rrh) {
				mr.add("H" + jump + val);
			}
		}

		for (int jump = 1; cc + jump <= ec && cr + jump <= er; jump++) {
			ArrayList<String> rrd = getMazePathDMM(cr + jump, cc + jump, er, ec);

			for (String val : rrd) {
				mr.add("D" + jump + val);
			}
		}

		return mr;

	}

}
