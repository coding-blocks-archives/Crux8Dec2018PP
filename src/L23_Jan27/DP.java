package L23_Jan27;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 27-Jan-2019
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 300;

		// System.out.println(fib(n));
		// System.out.println(fibTD(n, new int[n + 1]));
		// System.out.println(fibBU(n));
		// System.out.println(fibBUSE(n));

		// System.out.println(boardPathTD(0, n, new int[n]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));

		// System.out.println(LCSBU("saturdaybcghjvcbdhcuiydfhweuiyh",
		// "sundayvcdsghcsydgyuc"));

		// System.out.println(EditDistanceBU("saturdaybchxbvjkdsh,njkd",
		// "sundaycbkjsdhbvkuehvui"));

		int[] arr = new int[500];

		for (int i = 0; i < arr.length; i++)
			arr[i] = i + 1;

		// int[] arr = { 1, 2, 3, 4, 5 };
		// System.out.println(MCM(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MCMBU(arr));

		// int[] arr = { 2, 3, 5, 1, 4 };

		System.out.println(WineProblemTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(WineProblemBU(arr));

		int[] weight = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		int cap = 7;
		System.out.println(KnapsackTD(weight, price, cap, 0, new int[weight.length + 1][cap + 1]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	public static int fib(int n) {

		if (n == 1 || n == 0) {
			return n;
		}

		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static int fibTD(int n, int[] strg) {

		if (n == 1 || n == 0) {
			return n;
		}

		// reuse
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibTD(n - 1, strg);
		int fnm2 = fibTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// store
		strg[n] = fn;

		return fn;

	}

	public static int fibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int fibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}

		return strg[1];

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		// re-use
		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTD(curr + dice, end, strg);
		}

		// store
		strg[curr] = count;

		return count;

	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];

	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;
		}

		return strg[0];

	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr + 1, cc, er, ec, strg);
		int cv = mazePathTD(cr, cc + 1, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec - 1; col >= 0; col--) {
				strg[col] = strg[col] + strg[col + 1];
			}
		}

		return strg[0];

	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);
		}

		return ans;

	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {

					int o1 = strg[row][col + 1];
					int o2 = strg[row + 1][col];

					strg[row][col] = Math.max(o1, o2);
				}

			}
		}

		return strg[0][0];

	}

	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCSTD(ros1, ros2, strg) + 1;
		} else {
			int o1 = LCSTD(s1, ros2, strg);
			int o2 = LCSTD(ros1, s2, strg);

			ans = Math.max(o1, o2);
		}

		strg[s1.length()][s2.length()] = ans;

		return ans;

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);

		} else {

			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);

			ans = Math.min(r, Math.min(i, d)) + 1;

		}

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];

					strg[row][col] = Math.min(r, Math.min(i, d)) + 1;

				}

			}

		}

		return strg[0][0];

	}

	public static int MCM(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fc = MCM(arr, si, k, strg);
			int sc = MCM(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fc + sc + sw;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min;

		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fc = strg[si][k];
					int sc = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fc + sc + sw;

					if (total < min) {
						min = total;
					}

				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	public static int WineProblem(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return arr[si] * yr;
		}

		int sc = WineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int lc = WineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(sc, lc);

		return ans;

	}

	public static int WineProblemTD(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - ei + si;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int sc = WineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int lc = WineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int ans = Math.max(sc, lc);

		strg[si][ei] = ans;

		return ans;

	}

	public static int WineProblemBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;
				int yr = n - ei + si;

				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
				} else {
					int sc = strg[si + 1][ei] + arr[si] * yr;
					int lc = strg[si][ei - 1] + arr[ei] * yr;

					int ans = Math.max(sc, lc);

					strg[si][ei] = ans;
				}

			}

		}

		return strg[0][n - 1];
	}

	public static int KnapsackTD(int[] weight, int[] price, int cap, int vidx, int[][] strg) {

		if (vidx == weight.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int exclude = KnapsackTD(weight, price, cap, vidx + 1, strg);

		int include = 0;

		if (cap >= weight[vidx]) {
			include = KnapsackTD(weight, price, cap - weight[vidx], vidx + 1, strg) + price[vidx];
		}

		int ans = Math.max(exclude, include);

		strg[vidx][cap] = ans;

		return ans;

	}

}
