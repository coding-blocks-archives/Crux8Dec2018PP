
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Pattern1 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		while (row <= n) {

			// work of every row
			int col = 1;
			while (col <= n) {
				System.out.print("*");
				col = col + 1;
			}

			// update
			System.out.println();
			row = row + 1;
		}

	}

}
