package Assignments.Jan25;

import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jan-2019
 *
 */

public class Histogram {

	public static void main(String[] args) {

		long[] arr = { 10, 40, 30, 70, 15, 35, 3, 60 };

		System.out.println(areaHistogram(arr));

	}

	public static long areaHistogram(long[] arr) {

		Stack<Integer> stack = new Stack<>();
		long maxArea = 0;

		int i = 0;

		while (i < arr.length) {

			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {

				long temp = arr[stack.pop()];

				if (stack.isEmpty()) {
					int R = i;

					long areaFromPresentBar = temp * R;

					if (areaFromPresentBar > maxArea) {
						maxArea = areaFromPresentBar;
					}

				} else {

					int R = i;
					int L = stack.peek();

					long areaFromPresentBar = temp * (R - L - 1);

					if (areaFromPresentBar > maxArea) {
						maxArea = areaFromPresentBar;
					}

				}
			}

		}

		while (!stack.isEmpty()) {

			long temp = arr[stack.pop()];

			if (stack.isEmpty()) {
				int R = i;

				long areaFromPresentBar = temp * R;

				if (areaFromPresentBar > maxArea) {
					maxArea = areaFromPresentBar;
				}

			} else {

				int R = i;
				int L = stack.peek();

				long areaFromPresentBar = temp * (R - L - 1);

				if (areaFromPresentBar > maxArea) {
					maxArea = areaFromPresentBar;
				}
			}
		}

		return maxArea;

	}

}
