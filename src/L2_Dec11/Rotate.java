package L2_Dec11;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Dec-2018
 *
 */

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();

		int temp = n;
		int nod = 0;

		// number of digits
		while (temp != 0) {
			temp = temp / 10;
			nod++;
		}

		r = r % nod;

		if (r < 0) {
			r = r + nod;
		}

		// rotate
		int divisor = (int) Math.pow(10, r);
		int multiplier = (int) Math.pow(10, nod - r);

		int rem = n % divisor;
		int quotient = n / divisor;

		int ans = rem * multiplier + quotient;

		System.out.println(ans);

	}

}
