
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class SumN {

	public static void main(String[] args) {

		int n = 4;

		int sum = 0;
		int counter = 1;

		while (counter <= n) {

			sum = sum + counter;
			counter = counter + 1;
		}
		
		System.out.println(sum);
	}

}
