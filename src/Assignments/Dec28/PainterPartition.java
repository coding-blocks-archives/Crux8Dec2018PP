package Assignments.Dec28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class PainterPartition {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nop = scn.nextInt();
		int nob = scn.nextInt();

		int[] arr = new int[nob];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int lo = 0;
		int hi = 0;
		for (int val : arr) {
			hi += val;
		}

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(arr, nob, nop, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);
	}

	public static boolean isPossible(int[] arr, int nob, int nop, int mid) {

		int painter = 1;
		int timeRemaining = mid;

		// i keeps a track of number of boards painted
		int i = 0;
		while (i < arr.length) {

			if (arr[i] <= timeRemaining) {
				timeRemaining = timeRemaining - arr[i];
				i++;
			} else {
				painter++;
				timeRemaining = mid;

				if (painter > nop) {
					return false;
				}
			}

		}

		return true;

	}

}
