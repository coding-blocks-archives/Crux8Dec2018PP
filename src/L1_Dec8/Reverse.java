package L1_Dec8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Reverse {

	public static void main(String[] args) {

		int n = 12345;
		int ans = 0;

		while (n != 0) {

			int rem = n % 10;
			ans = ans * 10 + rem;
			n = n / 10;

		}

		System.out.println(ans);

	}

}
