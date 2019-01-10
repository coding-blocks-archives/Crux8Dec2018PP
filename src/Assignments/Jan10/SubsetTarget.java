package Assignments.Jan10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jan-2019
 *
 */

public class SubsetTarget {

	public static void main(String[] args) {

		int val = subsetInt(new int[] { 1, 2, 3 }, 0, 0, "", 3);
		System.out.println(val);
		subset(new int[] { 1, 2, 3 }, 0, 0, "", 3);

	}

	public static void subset(int[] arr, int vidx, int sum, String asf, int target) {

		if (sum == target) {
			System.out.print(asf + " ");
			return;
		}

		if (vidx == arr.length) {
			return;
		}

		subset(arr, vidx + 1, sum + arr[vidx], asf + " " + arr[vidx], target); // YES
		subset(arr, vidx + 1, sum, asf, target); // NO

	}

	public static int subsetInt(int[] arr, int vidx, int sum, String asf, int target) {

		if (sum == target) {
			return 1;
		}

		if (vidx == arr.length) {
			return 0;
		}

		int yes = subsetInt(arr, vidx + 1, sum + arr[vidx], asf + " " + arr[vidx], target); // YES
		int no = subsetInt(arr, vidx + 1, sum, asf, target); // NO

		return yes + no;
	}
}
