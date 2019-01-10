package Assignments.Jan10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class OnlyLadders {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int[] ladders = makeLadders(SOE(n));

		int ans = bpladders(0, n, ladders, "");
		System.out.println("\n" + ans);

	}

	public static int bpladders(int curr, int end, int[] ladders, String asf) {

		if (curr == end) {
			System.out.print(asf + " END ,");
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		if (ladders[curr] != 0) {
			count += bpladders(ladders[curr], end, ladders, asf + " " + curr);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				count += bpladders(curr + dice, end, ladders, asf + " " + curr);
			}
		}

		return count;

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

	public static int[] makeLadders(boolean[] primes) {

		int[] ladders = new int[primes.length];

		int left = 0;
		int right = primes.length - 1;

		while (left < right) {

			while (primes[left] == false) {
				left++;
			}

			while (primes[right] == false) {
				right--;
			}

			// if (left < right) {
			ladders[left] = right;
			left++;
			right--;
			// }

		}

		return ladders;

	}

}
