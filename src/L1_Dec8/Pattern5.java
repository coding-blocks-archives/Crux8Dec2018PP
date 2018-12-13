package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Pattern5 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;
		int nst = n;
		int nsp = 0;
		while (row <= n) {

			// work of every row
			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			// star
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// update
			System.out.println();
			row = row + 1;
			nst = nst - 1;
			nsp = nsp + 1;

		}

	}

}
