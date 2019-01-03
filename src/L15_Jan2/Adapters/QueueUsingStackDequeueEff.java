package L15_Jan2.Adapters;

import L15_Jan2.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class QueueUsingStackDequeueEff {

	DynamicStack primary = new DynamicStack();

	public void enqueue(int item) throws Exception {

		DynamicStack helper = new DynamicStack();
		try {

			while (!primary.isEmpty()) {
				helper.push(primary.pop());
			}

			primary.push(item);

			while (!helper.isEmpty()) {
				primary.push(helper.pop());
			}

		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}
	}

	public int dequeue() throws Exception {
		try {

			return primary.pop();

		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}

	public int getFront() throws Exception {
		try {
			return primary.peek();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
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

	public void display() {
		primary.display();
	}

}
