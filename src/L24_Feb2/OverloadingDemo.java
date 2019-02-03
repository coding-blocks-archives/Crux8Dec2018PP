package L24_Feb2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Feb-2019
 *
 */

public class OverloadingDemo {

	public static void main(String[] args) {

		// add(2, 3, 5);
		// add(2, 3.4);

		// add(2, 4, 6, 7);

		System.out.println(add(2, 3, 4, 5));
	}

	private static void add(int a, int b) {
		System.out.println("hi");
		System.out.println(a + b);
	}

	// public int add(int a, int b) {
	// return a + b;
	// }

	public static void add(int a, double b) {
		System.out.println(a + b);
	}

	public static void add(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static int add(int a, int b, int... args) {

		System.out.println("var args");
		int sum = 0;
		for (int val : args) {
			sum += val;
		}

		return sum;
	}

}
