package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Pattern9 {

	public static void main(String[] args) {

		int n = 9;

		int row = 1;
		int nst = 1;
		int nsp = n-1;
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
			nst = nst + 2;
			nsp = nsp - 1;

		}

	}

}
