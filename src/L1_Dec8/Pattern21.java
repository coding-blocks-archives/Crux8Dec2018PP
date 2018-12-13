package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		int nst = 1;
		int nsp = 2 * n - 3;

		while (row <= n) {

			// work
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			cst = 1;

			if (row == n) {
				cst = 2;
			}
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep

			nst = nst + 1;
			nsp = nsp - 2;

			row = row + 1;
			System.out.println();
		}
	}
}
