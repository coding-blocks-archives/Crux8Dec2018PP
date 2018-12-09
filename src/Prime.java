
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Prime {

	public static void main(String[] args) {

		int n = 7/0;

		int flag = 0;
		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				flag = 1 ;
			}

			div = div + 1;
		}

		if (flag == 0) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}

}
