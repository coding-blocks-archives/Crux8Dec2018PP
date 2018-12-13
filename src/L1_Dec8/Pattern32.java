package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int tr = 2 * n - 1;

		int nst = 1;

		int row = 1;

		while (row <= tr) {

			int val;
			if (row <= n)
				val = row;
			else
				val = tr - row + 1;

			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(val);

				cst = cst + 1;
			}

			// prep
			if (row < n) {
				nst = nst + 2;
			} else {
				nst = nst - 2;
			}

			row = row + 1;
			System.out.println();
		}

	}

}
