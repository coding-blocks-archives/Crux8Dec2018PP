package L7_Dec19;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Dec-2018
 *
 */

public class Recursion {

	public static void main(String[] args) {
		// PDI(4);
		// System.out.println("bye");
		// System.out.println(factorial(5));

		// System.out.println(power(2, 5));

		int[] arr = { 10, 20, 80, 30, 40, 80 };

		// displayArr(arr, 0);
		// System.out.println();
		// displayArrReverse(arr, 0);

		System.out.println(findFirstIndex(arr, 0, 80));
		System.out.println(findLastIndex(arr, 0, 80));

		int a = Integer.valueOf("10");
		String str = String.valueOf(10);

		printBox(1, 1, 5);
	}

	public static void PD(int n) {

		if (n == 0) {
			return;
		}

		// self work
		System.out.println(n);

		// smaller problem
		PD(n - 1);
	}

	public static void PI(int n) {

		if (n == 0) {
			return;
		}

		PI(n - 1);

		// self work
		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0) {
			return;
		}

		// self work
		System.out.println(n);

		PDI(n - 1);

		// self work
		System.out.println(n);
	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1);
		int fn = fnm1 * n;

		return fn;
	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);

		int pn = pnm1 * x;

		return pn;

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

	public static void displayArr(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		displayArr(arr, vidx + 1);
	}

	public static void displayArrReverse(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayArrReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int maxArr(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int sp = maxArr(arr, vidx + 1);

		// self work
		if (sp > arr[vidx]) {
			return sp;
		} else {
			return arr[vidx];
		}

	}

	public static int findFirstIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		} else {
			return findFirstIndex(arr, vidx + 1, item);
		}

	}

	public static int findLastIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int recRes = findLastIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && recRes == -1) {
			return vidx;
		} else {
			return recRes;
		}

	}

	public static int[] findAllIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] baseRes = new int[count];
			return baseRes;
		}

		if (arr[vidx] == item) {
			int[] recRes = findAllIndex(arr, vidx + 1, item, count + 1);
			recRes[count] = vidx;
			return recRes;
		} else {
			int[] recRes = findAllIndex(arr, vidx + 1, item, count);
			return recRes;
		}

	}

	public static void printBox(int row, int col, int n) {

		if (row > n) {
			return;
		}

		if (col > n) {
			System.out.println();
			printBox(row + 1, 1, n);
			return;
		}

		System.out.print("*");
		printBox(row, col + 1, n);
	}

}
