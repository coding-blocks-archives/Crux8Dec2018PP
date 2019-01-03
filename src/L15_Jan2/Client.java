package L15_Jan2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.addLast(80);

		list.display();
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(4));
		System.out.println(list.removeFirst());
		list.display();
		System.out.println(list.removeLast());
		list.display();
		System.out.println(list.getAt(4));
		list.removeAt(3);
		list.display();
		list.addFirst(110);
		list.display();
		list.addAt(2, 200);
		list.display();

	}

}
