package Assignments.Dec28;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

public class MaxSumPath {

	public static void main(String[] args) {

		int[] one = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] two = { 1, 5, 7, 8, 10, 15, 16, 19 };

		int sum1 = 0;
		int sum2 = 0;

		int i = 0, j = 0;
		int tsum = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				sum1 += one[i];
				i++;
			} else if (one[i] > two[j]) {
				sum2 += two[j];
				j++;
			} else {

				sum1 += one[i];
				sum2 += two[j];
				tsum += Math.max(sum1, sum2);

				sum1 = 0;
				sum2 = 0;

				i++;
				j++;

			}

		}

		while (i < one.length) {
			sum1 += one[i];
			i++;
		}

		while (j < two.length) {
			sum2 += two[j];
			j++;
		}

		tsum += Math.max(sum1, sum2);

		System.out.println(tsum);

	}

}
