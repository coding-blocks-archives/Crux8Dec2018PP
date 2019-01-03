package L15_Jan2.Adapters;

import L13_Dec29.Stack;
import L15_Jan2.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class Client {

	public static void main(String[] args) throws Exception {
		StackUsingQueuePushEff s = new StackUsingQueuePushEff();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		System.out.println(s.pop());
		s.display();

		QueueUsingStackDequeueEff q = new QueueUsingStackDequeueEff();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.display();

	}

}
