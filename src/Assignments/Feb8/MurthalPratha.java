package Assignments.Feb8;

import java.util.Scanner;

public class MurthalPratha {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int tp = scn.nextInt();
		int tc = scn.nextInt();

		int[] arr = new int[tc];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int finalAns = Integer.MAX_VALUE;

		int lo = 0;
		int hi = Integer.MAX_VALUE;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isPossible(arr, mid, tp)) {
				hi = mid - 1;
				finalAns = mid;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(finalAns);

	}

	private static boolean isPossible(int[] arr, int mid, int tp) {

		for (int i = 0; i < arr.length; i++) {

			int time = 0;
			int count = 1;
			while (time + count * arr[i] <= mid && tp > 0) {
				time = time + count * arr[i];
				count++;
				tp--;
			}

			if (tp == 0) {
				return true;
			}
		}
		return false;
	}

}
