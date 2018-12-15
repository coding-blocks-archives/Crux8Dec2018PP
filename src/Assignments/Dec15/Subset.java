package Assignments.Dec15;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2018
 *
 */

public class Subset {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		for (int n = 0; n <= Math.pow(2, arr.length) - 1; n++) {

			// decimal to binary
			int i = 0;

			int num = n ;
			while (num != 0) {

				int rem = num % 2;

				if (rem == 1) {
					System.out.print(arr[i] + " ");
				}

				num = num / 2;
				i++;
			}

			System.out.println();
		}

	}

}
