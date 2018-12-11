package L2_Dec11;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class DecimalToBinary {

	public static void main(String[] args) {

		int n = 37;
		int ans = 0;
		int multiplier = 1;

		while (n != 0) {

			int rem = n % 2;
			ans = ans + (rem * multiplier);

			n = n / 2;
			multiplier = multiplier * 10;

		}

		System.out.println(ans);

	}

}
