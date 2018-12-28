package Assignments.Dec28;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class HelpRamu {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t > 0) {
			int c1 = scn.nextInt();
			int c2 = scn.nextInt();
			int c3 = scn.nextInt();
			int c4 = scn.nextInt();

			int nr = scn.nextInt();
			int nc = scn.nextInt();

			int[] rickshaw = new int[nr];

			for (int i = 0; i < rickshaw.length; i++) {
				rickshaw[i] = scn.nextInt();
			}

			int[] cars = new int[nc];
			for (int i = 0; i < cars.length; i++) {
				cars[i] = scn.nextInt();
			}

			int ans = minFare(c1, c2, c3, c4, nr, nc, rickshaw, cars);

			System.out.println(ans);
			t--;
		}

	}

	public static int minFare(int c1, int c2, int c3, int c4, int nr, int nc, int[] rickshaw, int[] cars) {

		int minFareRickshaw = fare(c1, c2, c3, rickshaw);
		int minFareCars = fare(c1, c2, c3, cars);

		System.out.println(minFareRickshaw + "  " + minFareCars);
		return Math.min(minFareRickshaw + minFareCars, c4);

	}

	private static int fare(int c1, int c2, int c3, int[] freq) {

		int min = 0;

		for (int i = 0; i < freq.length; i++) {
			min += Math.min(freq[i] * c1, c2);
		}
		return Math.min(min, c3);
	}

}
