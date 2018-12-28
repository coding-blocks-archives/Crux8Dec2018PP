package L4_Dec14;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Dec-2018
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] arr = takeInput();

		// int[] arr = { 80, 70, 50, 60, 10 };
		// int[] arr = { 88, 11, 44, 99, 55 };
		// display(arr);
		//
		// System.out.println(max(arr));
		//
		// System.out.println(linearSearch(arr, 2800));
		// System.out.println(binarySearch(arr, 15));

		// bubbleSort(arr);
		// selectionSort(arr);
		// insertionSort(arr);

		long start = System.currentTimeMillis();
		int[] arr = new int[1000000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		bubbleSort(arr);
		long end = System.currentTimeMillis();

		System.out.println(end - start);
		// display(arr);
	}

	public static int[] takeInput() {

		System.out.println("Size?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i <= arr.length - 1; i++) {
			System.out.println("arr[" + i + "] ?");
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

	public static int max(int[] arr) {

		int max = Integer.MIN_VALUE;
		for (int val : arr) {
			if (val > max) {
				max = val;
			}
		}

		return max;

	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

	}

	public static int[] rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0) {
			rot = rot + arr.length;
		}

		int[] ans = new int[arr.length];

		for (int i = 0; i < ans.length; i++) {

			if (i < rot) {
				ans[i] = arr[i + arr.length - rot];
			} else {
				ans[i] = arr[i - rot];
			}
		}

		return ans;
	}

	public static int[] inverse(int[] arr) {

		int[] inv = new int[arr.length];

		for (int i = 0; i < inv.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;

	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;

		boolean flag = true;
		for (int counter = 0; counter < n - 1; counter++) {

			// System.out.println("Counter " + counter);
			for (int j = 0; j < n - counter - 1; j++) {

				if (arr[j] > arr[j + 1]) {

					flag = false;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			if (flag) {
				break;
			}

			// display(arr);
		}

	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {

			int min = counter;

			for (int j = counter + 1; j <= n - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;

		}

	}

	public static void insertionSort(int[] arr) {

		for (int counter = 1; counter < arr.length; counter++) {

			int item = arr[counter];

			int j = counter - 1;
			while (j >= 0 && arr[j] > item) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = item;
		}
	}

}
