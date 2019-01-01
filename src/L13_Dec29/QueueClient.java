package L13_Dec29;

import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class QueueClient {

	public static void main(String[] args) throws Exception {

		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// q.enqueue(60);
		// q.enqueue(70);
		// q.display();

		// displayReverse(q, 0);
		// q.display();
		// actualReverse(q);
		// q.display();

		int[] arr = { -3, -1, 8, 6, -4, -8, -9, 10 };
		firstNegativeIntegerOfWindow(arr, 4);
	}

	public static void displayReverse(Queue q, int count) throws Exception {

		if (count == q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);

		displayReverse(q, count + 1);

		System.out.println(temp);
	}

	public static void actualReverse(Queue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();
		actualReverse(q);
		q.enqueue(temp);
	}

	public static void firstNegativeIntegerOfWindow(int[] arr, int k) throws Exception {

		Queue q = new Queue(100);

		for (int i = 0; i < k; i++) {

			if (arr[i] < 0) {
				q.enqueue(i);
			}
		}

		for (int i = k; i < arr.length; i++) {

			// ans
			if (q.isEmpty()) {
				System.out.println("0");
			} else {
				System.out.println(arr[q.getFront()]);
			}

			// useless remove -> remove the elements which are out of this window
			if (!q.isEmpty() && q.getFront() <= i - k) {
				q.dequeue();
			}

			// insert
			if (arr[i] < 0) {
				q.enqueue(i);
			}
		}

		if (q.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(arr[q.getFront()]);
		}

	}

}
