package L17_Jan6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Jan-2019
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
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

		// smaller problem
		// for (Node child : node.children) {
		// display(child);
		// }

		for (int i = node.children.size() - 1; i >= 0; i--) {
			display(node.children.get(i));
		}

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

	}

}
