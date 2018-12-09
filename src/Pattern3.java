
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Pattern3 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;
		int nst = n;
		while (row <= n) {

			// work of every row
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col = col + 1;
			}

			// update
			System.out.println();
			row = row + 1;
			nst = nst - 1;
		}

	}

}
