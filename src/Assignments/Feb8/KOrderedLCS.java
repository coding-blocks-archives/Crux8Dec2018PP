package Assignments.Feb8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Feb-2019
 *
 */

public class KOrderedLCS {

	public static void main(String[] args) {

		System.out.println(KOrderedLCS("yzwa", "byz", 1));
	}

	public static int KOrderedLCS(String s1, String s2, int k) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		// option 1 : char match
		int ans1 = 0;
		if (ch1 == ch2) {
			ans1 = KOrderedLCS(ros1, ros2, k) + 1;
		}

		// option 2 : use k
		int ans2 = 0;
		if (k >= 1)
			ans2 = KOrderedLCS(ros1, ros2, k - 1) + 1;

		// option 3 : char mismatch
		int ans3 = 0;
		int c1 = KOrderedLCS(s1, ros2, k);
		int c2 = KOrderedLCS(ros1, s2, k);
		ans3 = Math.max(c1, c2);

		int max = Math.max(ans1, Math.max(ans2, ans3));

		return max;

	}

}
