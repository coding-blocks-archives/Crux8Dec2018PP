package Assignments.Dec28;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int nsp = 2 * n - 3;

		for (int row = 1; row <= n; row++) {

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			int cst = 1;

			if (row == n) {
				cst = 2;
			}
			for (; cst <= nst; cst++) {
				System.out.print("*");
			}

			System.out.println();
			nst++;
			nsp = nsp - 2;
		}
	}

}
