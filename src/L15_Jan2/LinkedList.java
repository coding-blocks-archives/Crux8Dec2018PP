package L15_Jan2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;

	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	// O(n)
	public void display() {

		System.out.println("---------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("---------------");
	}

	// O(1)
	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// data members updation
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	// O(1)
	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			nn.next = this.head;

		// data members updation
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(n)
	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			// attach
			nm1.next = nn;
			nn.next = np1;

			// data members update
			this.size++;

		}

	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;
		}

	}

	public void reverseDI() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left <= right) {
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			// int ln = getAt(left) ;
			// int rn = getAt(right) ;
			// int temp = ln;
			// ln = rn;
			// rn = temp;

			left++;
			right--;
		}

	}

	public void reversePI() {

		Node prev = this.head;
		Node curr = this.head.next;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;
	}

	public void reversePR() {
		reversePR(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		this.tail.next = null;

	}

	private void reversePR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		// Node ahead = curr.next;
		//
		// curr.next = prev;
		// reversePR(curr, ahead);

		reversePR(curr, curr.next);
		curr.next = prev;

	}

	public void reverseDR() {

		reverseDR(this.head, this.head, 0);
	}

	private Node reverseDR(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node rv = reverseDR(left, right.next, count + 1);

		if (count >= this.size / 2) {

			int temp = rv.data;
			rv.data = right.data;
			right.data = temp;

		}

		return rv.next;

	}

	private class HeapMover {
		Node left;
	}

	public void reverseDRHeap() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;

		reverseDRHeap(mover, this.head, 0);
	}

	private void reverseDRHeap(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDRHeap(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;

	}

	public void fold() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;
		// fold(mover, this.head, 0);

		foldReturn(this.head, this.head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		if (count > this.size / 2) {
			Node temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;
			mover.left = temp;
		}

		if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	private Node foldReturn(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		left = foldReturn(left, right.next, count + 1);

		Node temp = null;

		if (count > this.size / 2) {
			temp = left.next;
			left.next = right;
			right.next = temp;
		}

		if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

		return temp;
	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int kthFromLast(int k) {

		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;

		while (this.size != 0) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.size += curr.size;
				prev.tail = curr.tail;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}
}
