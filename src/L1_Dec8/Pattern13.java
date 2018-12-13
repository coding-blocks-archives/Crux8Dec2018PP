package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Pattern13 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;
		int nst = 1;

		while (row <= 2 * n - 1) {

			// work of every row

			// star
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// update
			System.out.println();

			if (row < n) {
				nst = nst + 1;
			} else {
				nst = nst - 1;
			}

			row = row + 1;

		}

	}

}
