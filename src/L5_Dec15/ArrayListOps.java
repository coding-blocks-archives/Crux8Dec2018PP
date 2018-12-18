package L5_Dec15;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Dec-2018
 *
 */

public class ArrayListOps {

	public static void main(String[] args) {

		int[] one = { 9, 9, 9, 9 };
		int[] two = { 9, 9, 9 };

		System.out.println(intersection(one, two));
		System.out.println(sum(one, two));
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] > two[j]) {
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else {
				ans.add(one[i]);
				i++;
				j++;
			}

		}
		return ans;
	}

	public static ArrayList<Integer> sum(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0) {
				sum += one[i];
			}

			if (j >= 0) {
				sum += two[j];
			}

			int rem = sum % 10;
			ans.add(0, rem);
			carry = sum / 10;

			i--;
			j--;

		}

		if (carry != 0) {
			ans.add(0, carry);
		}

		return ans;
	}

}
