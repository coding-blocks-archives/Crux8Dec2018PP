package L15_Jan2.Adapters;

import L15_Jan2.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class StackUsingQueuePushEff {

	DynamicQueue primary = new DynamicQueue();

	public void push(int item) throws Exception {

		try {
			primary.enqueue(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}
	}

	public int pop() throws Exception {

		try {
			DynamicQueue helper = new DynamicQueue();

			while (primary.size() != 1) {
				helper.enqueue(primary.dequeue());
			}

			int rv = primary.dequeue();
			primary = helper;

			return rv;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int peek() throws Exception {

		try {
			DynamicQueue helper = new DynamicQueue();

			while (primary.size() != 1) {
				helper.enqueue(primary.dequeue());
			}

			int rv = primary.dequeue();
			helper.enqueue(rv);
			primary = helper;

			return rv;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int size() {
		return primary.size();
	}

	public boolean isEmpty() {
		return primary.isEmpty();
	}

	public boolean isFull() {
		return primary.isFull();
	}

	public void display() throws Exception {
		System.out.println("--------------");
		displayReverse(0);
		System.out.println(".");
		System.out.println("--------------");
	}

	private void displayReverse(int count) throws Exception {

		if (count == primary.size()) {
			return;
		}

		int temp = primary.dequeue();
		primary.enqueue(temp);

		displayReverse(count + 1);

		System.out.print(temp + " ");
	}

}