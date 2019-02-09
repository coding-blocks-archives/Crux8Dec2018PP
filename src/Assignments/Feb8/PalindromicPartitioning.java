package Assignments.Feb8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Feb-2019
 *
 */

public class PalindromicPartitioning {

	public static void main(String[] args) {

		String str = "abcdefe";
		System.out.println(partitioning(str, 0, str.length() - 1));
	}

	public static int partitioning(String str, int si, int ei) {

		if (si == ei || isPalindrome(str, si, ei)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fc = partitioning(str, si, k);
			int sc = partitioning(str, k + 1, ei);

			int total = fc + sc + 1;

			if (total < min) {
				min = total;
			}
		}

		return min;

	}

	public static boolean isPalindrome(String str, int si, int ei) {

		int left = si;
		int right = ei;

		while (left <= right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;

	}

}
