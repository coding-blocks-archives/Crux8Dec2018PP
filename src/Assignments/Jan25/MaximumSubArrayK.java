package Assignments.Jan25;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jan-2019
 *
 */

public class MaximumSubArrayK {

	public static void main(String[] args) {

		int[] arr = { 60, 30, 5, 40, 20, 50, 60, 20, 70 };
		int k = 4;

		Deque<Integer> queue = new LinkedList<>();

		for (int i = 0; i < k; i++) {

			while (!queue.isEmpty() && arr[queue.getLast()] < arr[i]) {
				queue.removeLast();
			}

			queue.addLast(i);

		}

		for (int i = k; i < arr.length; i++) {

			// print
			System.out.println(arr[queue.getFirst()]);

			// remove the elements which are outside this window
			if (queue.getFirst() <= i - k) {
				queue.removeFirst();
			}

			// new element will remove the prev elements
			while (!queue.isEmpty() && arr[queue.getLast()] < arr[i]) {
				queue.removeLast();
			}

			// add
			queue.addLast(i);

		}

		System.out.println(arr[queue.getFirst()]);

	}

}
