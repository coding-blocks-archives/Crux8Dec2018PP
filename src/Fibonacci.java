
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Fibonacci {

	public static void main(String[] args) {

		int n = 5;

		int a = 0;
		int b = 1;

		int count = 0;

		while (count <= n) {

			System.out.println(a);

			int sum = a + b;
			a = b;
			b = sum;
			
			count = count + 1;
		}

	}

}
