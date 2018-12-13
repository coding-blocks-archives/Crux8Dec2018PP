package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class Pattern15 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		int nst = n;
		int nsp = 0;
		while (row <= 2 * n - 1) {

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep

			if (row < n) {
				nst = nst - 1;
				nsp = nsp + 2;
			} else {
				nst = nst + 1;
				nsp = nsp - 2;
			}
			row = row + 1;
			System.out.println();
		}
	}
}
