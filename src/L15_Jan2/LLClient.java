package L15_Jan2;

import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(840);
		list.addLast(50);
		list.addLast(160);
		list.addLast(470);
		list.addLast(80);
		list.addLast(90);

		list.display();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(4));
		// System.out.println(list.removeFirst());
		list.display();
		// System.out.println(list.removeLast());
		list.display();
		System.out.println(list.getAt(4));
		// list.removeAt(3);
		// list.display();
		list.addFirst(110);
		list.display();
		list.addAt(2, 200);
		list.display();
		list.addFirst(900);
		//
		// list.reverseDRHeap();
		// list.display();
		// list.fold();
		// list.display();
		// list.addLast(120);
		// list.display();
		// System.out.println(list.mid());
		// System.out.println(list.kthFromLast(3));
		//
		// list.kReverse(4);
		// list.display();

		String str = "hbc";
		System.out.println(str.compareTo("def"));

		list.display();

		// LinkedList list2 = new LinkedList();
		// list2.addLast(3);
		// list2.addLast(6);
		// list2.addLast(14);
		// list2.addLast(26);
		// list2.addLast(90);
		// list2.display();
		// LinkedList list3 = list.mergeTwoSortedLL(list2);
		// list3.display();

		list.mergeSort();
		list.display();

		list.createDummyLL();
		list.detectRemoveLoop();
		list.display();

	}

}
