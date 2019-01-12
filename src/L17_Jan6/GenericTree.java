package L17_Jan6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Jan-2019
 *
 */

public class GenericTree {

	Scanner scn;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree(String str) {
		scn = new Scanner(str);
		this.root = construct(null, -1);
	}

	// create the ith child of parent
	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for  " + ith + " child of " + parent.data);
		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println("No of children for " + nn.data);
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {
			Node child = construct(nn, i);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("--------------------");
		display(this.root);
		System.out.println("--------------------");
	}

	private void display(Node node) {

		// self work

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		// smaller problem
		for (Node child : node.children) {
			display(child);
		}

		// for (int i = node.children.size() - 1; i >= 0; i--) {
		// display(node.children.get(i));
		// }

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int sum = 0;

		for (Node child : node.children) {
			sum += size(child);
		}

		return sum + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			tm = Math.max(tm, cm);
		}

		return tm;

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);

			if (cf)
				return true;
		}

		return false;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {

			int ch = ht(child);
			th = Math.max(ch, th);
		}

		return th + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		// self work
		int l = 0;
		int r = node.children.size() - 1;

		while (l < r) {

			Node ln = node.children.get(l);
			Node rn = node.children.get(r);

			node.children.set(r, ln);
			node.children.set(l, rn);

			l++;
			r--;
		}

		for (Node child : node.children) {
			mirror(child);
		}
	}

	public void display2() {
		display2(this.root);
	}

	private void display2(Node node) {

		System.out.println("Hii " + node.data);

		for (Node child : node.children) {
			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming back from " + child.data);

		}

		System.out.println("Bye " + node.data);

	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		postorder(this.root);
		System.out.println();
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.print(node.data + " ");

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {

			// remove
			Node rn = queue.removeFirst();

			// print
			System.out.print(rn.data + " ");

			// child
			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}
		System.out.println();

	}

	public void levelOrderLW() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		primary.addLast(this.root);

		while (!primary.isEmpty()) {

			Node rn = primary.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				System.out.println();
				primary = helper;
				helper = new LinkedList<>();
			}

		}

	}

	public void levelOrderZZ() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.addLast(this.root);

		int count = 0;

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {

				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {
				count++;
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
			}

		}

	}

	public void printAtLevel(int level) {
		printAtLevel(this.root, 0, level);
	}

	private void printAtLevel(Node node, int count, int level) {

		if (count == level)
			System.out.println(node.data);

		for (Node child : node.children) {
			printAtLevel(child, count + 1, level);
		}
	}

}
