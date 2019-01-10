package Assignments.Jan10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class Chessboard1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int ans = chessboard(0, 0, n - 1, n - 1, "");
		System.out.println(ans);

	}

	public static int chessboard(int cr, int cc, int er, int ec, String asf) {

		if (cr == er && cc == ec) {
			System.out.println(asf + "{" + cr + "-" + cc + "}");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		// knights
		count += chessboard(cr + 2, cc + 1, er, ec, asf + "{" + cr + "-" + cc + "}K");
		count += chessboard(cr + 1, cc + 2, er, ec, asf + "{" + cr + "-" + cc + "}K");

		if (cr == 0 || cc == 0 || cr == er || cc == ec) {

			// rook horizontally
			for (int move = 1; move <= ec - cc; move++) {
				count += chessboard(cr, cc + move, er, ec, asf + "{" + cr + "-" + cc + "}R");
			}

			// rook vertically
			for (int move = 1; move <= er - cr; move++) {
				count += chessboard(cr + move, cc, er, ec, asf + "{" + cr + "-" + cc + "}R");
			}

		}

		// bishop diagonally
		if (cr == cc || cr + cc == er) {

			for (int move = 1; move <= er - cr && move <= ec - cc; move++) {
				count += chessboard(cr + move, cc + move, er, ec, asf + "{" + cr + "-" + cc + "}B");
			}
		}

		return count;
	}

}
