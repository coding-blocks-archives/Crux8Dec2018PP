package Assignments.Dec28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nob = scn.nextInt();
		int nos = scn.nextInt();

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

			if (isPossible(arr, nob, nos, mid)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);
	}

	public static boolean isPossible(int[] arr, int nob, int nos, int mid) {

		int student = 1;
		int pagesRead = 0;

		int i = 0;
		while (i < nob) {

			if (pagesRead + arr[i] <= mid) {
				pagesRead = pagesRead + arr[i];
				i++;
			} else {

				student++;
				pagesRead = 0;

				if (student > nos) {
					return false;
				}
			}

		}

		return true;
	}

}
