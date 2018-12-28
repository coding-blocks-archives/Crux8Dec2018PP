package Assignments.Dec28;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class Triplet {

	public static void main(String[] args) {

		int[] arr = { 5, 7, 9, 1, 2, 4, 6, 8, 3 };

		Arrays.sort(arr);

		int target = 10;

		for (int i = 0; i < arr.length; i++) {

			int j = i + 1;
			int k = arr.length - 1;

			while (j < k) {

				if (arr[j] + arr[k] < target - arr[i]) {
					j++;
				} else if (arr[j] + arr[k] > target - arr[i]) {
					k--;
				} else {
					System.out.println(arr[i] + ", " + arr[j] + " and " + arr[k]);
					j++;
					k--;
				}
			}
		}

	}

}
