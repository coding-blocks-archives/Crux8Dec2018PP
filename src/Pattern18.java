
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class Pattern18 {

	public static void main(String[] args) {

		int n = 7;

		int row = 1;

		int nst = 1;
		int nsp = n / 2;

		while (row <= n) {

			// work

			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {

				if (cst == 1 || cst == nst)
					System.out.print("*");
				else
					System.out.print(" ");

				cst = cst + 1;
			}

			// prep

			if (row <= n / 2) {
				nst = nst + 2;
				nsp = nsp - 1;
			} else {
				nst = nst - 2;
				nsp = nsp + 1;
			}
			row = row + 1;
			System.out.println();
		}
	}
}
