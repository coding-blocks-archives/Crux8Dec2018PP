package L2_Dec11;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class DecimalToAnyBase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int db = scn.nextInt();
		
		int ans = 0;
		int multiplier = 1;

		while (n != 0) {

			int rem = n % db;
			ans = ans + (rem * multiplier);

			n = n / db;
			multiplier = multiplier * 10;

		}

		System.out.println(ans);

		

	}

}
