package Assignments.Dec28;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class DoubleSidedArrow {

	public static void main(String[] args) {

		int n = 7;

		int nst = 1;
		int nsp1 = n - 1;
		int nsp2 = -1;

		for (int row = 1; row <= n; row++) {

			int val = row;

			if (row > n / 2) {
				val = n - row + 1;
			}
			for (int csp = 1; csp <= nsp1; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				val--;
			}

			for (int csp = 1; csp <= nsp2; csp++) {
				System.out.print(" ");
			}

			int cst = 1;
			// val++;
			if (row == 1 || row == n) {
				cst = 2;
			}
			for (; cst <= nst; cst++) {
				val++;
				System.out.print(val);
				// val++;
			}

			System.out.println();

			if (row <= n / 2) {
				nst++;
				nsp1 -= 2;
				nsp2 += 2;
			} else {
				nst--;
				nsp1 += 2;
				nsp2 -= 2;
			}
		}
	}

}
