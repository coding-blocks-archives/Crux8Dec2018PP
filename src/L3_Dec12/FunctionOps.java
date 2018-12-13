package L3_Dec12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2018
 *
 */

public class FunctionOps {

	public static void main(String[] args) {

		// printPrimes(10, 200);
		printArmstrong(1, 1000);
	}

	public static void printPrimes(int lo, int hi) {

		for (int i = lo; i <= hi; i++) {

			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrime(int n) {

		boolean flag = true;
		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				flag = false;
			}

			div = div + 1;
		}

		return flag;
	}

	public static void printArmstrong(int lo, int hi) {

		for (int i = lo; i <= hi; i++) {

			int nod = numberOfDigits(i);
			if (isArmstrong(i, nod)) {
				System.out.println(i);
			}
		}
	}

	public static int numberOfDigits(int num) {

		int c = 0;

		while (num != 0) {
			c = c + 1;
			num = num / 10;
		}

		return c;

	}

	public static boolean isArmstrong(int num, int digits) {

		int temp = num;
		int sum = 0;

		while (num != 0) {

			int rem = num % 10;
			sum = sum + (int) Math.pow(rem, digits);

			num = num / 10;
		}

		// if (sum == temp) {
		// return true;
		// } else {
		// return false;
		// }

		return sum == temp;
	}

}
