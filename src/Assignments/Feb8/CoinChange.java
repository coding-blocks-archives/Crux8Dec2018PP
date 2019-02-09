package Assignments.Feb8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Feb-2019
 *
 */

public class CoinChange {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 3, 6 };
		System.out.println(coinChange(arr, 0, 10, ""));
	}

	public static int coinChange(int[] arr, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return 1;
		}

		if (amount < 0 || vidx == arr.length) {
			return 0;
		}

		int no = coinChange(arr, vidx + 1, amount, ans);
		int yes = coinChange(arr, vidx, amount - arr[vidx], ans + arr[vidx] + " ");

		return no + yes;

	}
}
