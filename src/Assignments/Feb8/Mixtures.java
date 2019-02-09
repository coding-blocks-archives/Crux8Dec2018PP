package Assignments.Feb8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Feb-2019
 *
 */

public class Mixtures {

	public static void main(String[] args) {

		int[] arr = { 40, 60, 20 };
		System.out.println(mixtures(arr, 0, arr.length - 1));

	}

	public static int mixtures(int[] arr, int si, int ei) {

		if (si == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fc = mixtures(arr, si, k);
			int sc = mixtures(arr, k + 1, ei);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int total = fc + sc + sw;

			if (total < min) {
				min = total;
			}
		}

		return min;

	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}
}
