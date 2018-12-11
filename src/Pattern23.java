
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class Pattern23 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		int nst = 1;
		int nsp = n - 1;

		while (row <= n) {

			int val = row;

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("\t");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {

				System.out.print(val + "\t");

				if (cst <= nst / 2) {
					val = val + 1;
				} else {
					val = val - 1;
				}
				cst = cst + 1;

			}

			// prep

			nst = nst + 2;
			nsp = nsp - 1;

			row = row + 1;
			System.out.println();
		}
	}
}
