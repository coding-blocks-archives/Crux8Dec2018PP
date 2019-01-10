package Assignments.Jan10;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class SnakesLadders {

	public static void main(String[] args) {

		int n = 14;

		int[] snakesladders = makeSnakesLadders(SOE(n));

		// for (int val : snakesladders) {
		// System.out.println(val);
		// }

		System.out.println(bpsnakesladders(0, n, snakesladders, new int[] { 6, 5, 2, 5, 2 }, 0));

	}

	public static boolean bpsnakesladders(int curr, int end, int[] snakesladders, int[] dices, int vidx) {

		if (curr == end) {
			return true;
		}

		if (curr > end) {
			return false;
		}

		if (vidx == dices.length) {
			return false;
		}

		if (snakesladders[curr] != 0) {
			return bpsnakesladders(snakesladders[curr], end, snakesladders, dices, vidx);
		} else {
			return bpsnakesladders(curr + dices[vidx], end, snakesladders, dices, vidx + 1);
		}

	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			// dont speak the table of 4
			if (primes[table] == false) {
				continue;
			}

			for (int multiplier = 2; table * multiplier <= n; multiplier++) {
				primes[table * multiplier] = false;
			}

		}

		return primes;
	}

	public static int[] makeSnakesLadders(boolean[] primes) {

		int[] snakesladders = new int[primes.length];

		int left = 0;
		int right = primes.length - 1;

		int count = 1;

		while (left < right) {

			while (primes[left] == false) {
				left++;
			}

			while (primes[right] == false) {
				right--;
			}

			if (count % 2 == 1)
				snakesladders[left] = right;
			else
				snakesladders[right] = left;

			count++;
			left++;
			right--;

		}

		return snakesladders;

	}

}
