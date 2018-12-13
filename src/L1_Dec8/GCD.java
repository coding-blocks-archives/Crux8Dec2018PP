package L1_Dec8;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class GCD {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int divident = s.nextInt();
		int divisor = s.nextInt();

		while (divident % divisor != 0) {

			int rem = divident % divisor;

			// update
			divident = divisor;
			divisor = rem;
		}

		System.out.println(divisor);

	}

}
