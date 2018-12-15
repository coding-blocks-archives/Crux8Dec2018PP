package Assignments.Dec15;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2018
 *
 */

public class IncDec {

	public static void main(String[] args) {
		System.out.println(validinvalid());
	}

	public static boolean validinvalid() {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int prev = scn.nextInt();
		boolean gd = true;

		for (int i = 1; i <= n - 1; i++) {

			int curr = scn.nextInt();

			if (gd) {

				if (curr < prev) {
					// continue
				} else if (curr == prev) {
					return false;
				} else {
					gd = false;
				}

			} else {

				if (curr > prev) {
					// continue
				} else {
					return false;
				}
			}

			prev = curr;

		}

		return true;

	}
}
