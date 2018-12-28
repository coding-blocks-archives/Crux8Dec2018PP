package L11_Dec25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Dec-2018
 *
 */

public class SortingRecursion {

	public static void main(String[] args) {

		// 50, 40, 80, 90, 70, 10, 30, 60, 120
		int[] arr = { 20, 10, 30, 5, 3, 2, 40, 15 };

		// int[] sorted = mergeSort(arr, 0, arr.length - 1);

		quickSort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int i = 0;
		int j = 0;
		int k = 0;

		int[] merged = new int[one.length + two.length];

		while (i < one.length && j < two.length) {

			if (one[i] <= two[j]) {
				merged[k] = one[i];
				k++;
				i++;
			} else {
				merged[k] = two[j];
				k++;
				j++;
			}

		}

		if (i == one.length) {

			while (j < two.length) {
				merged[k] = two[j];
				k++;
				j++;
			}
		}

		if (j == two.length) {

			while (i < one.length) {
				merged[k] = one[i];
				k++;
				i++;
			}
		}

		return merged;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] ans = mergeTwoSortedArrays(fh, sh);

		return ans;
	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		// partitioning
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}

		// smaller problems
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
