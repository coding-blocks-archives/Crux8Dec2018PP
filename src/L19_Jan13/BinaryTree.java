package L19_Jan13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jan-2019
 *
 */

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {

		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = construct(null, true);
	}

	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}

		}

		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;

	}

	public BinaryTree(int[] pre, int[] in) {

		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (ilo > ihi || plo > phi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;

		// search
		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;
	}

	public void display() {

		System.out.println("-----------");
		display(this.root);
		System.out.println("-----------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sp = ht(node.left) + ht(node.right) + 2;

		return Math.max(sp, Math.max(ld, rd));

	}

	private class DiaPair {

		int diameter = 0;
		int ht = -1;
	}

	public int diameter2() {
		return diameter2(this.root).diameter;
	}

	private DiaPair diameter2(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter2(node.left);
		DiaPair rdp = diameter2(node.right);

		DiaPair np = new DiaPair();

		np.ht = Math.max(ldp.ht, rdp.ht) + 1;

		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sp = ldp.ht + rdp.ht + 2;

		np.diameter = Math.max(sp, Math.max(ld, rd));

		return np;

	}

	public boolean isBalanced() {
		return isBalanced(this.root);
	}

	private boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = Math.abs(ht(node.left) - ht(node.right));

		if (lb && rb && (bf == 0 || bf == 1)) {
			return true;
		} else {
			return false;
		}
	}

	private class BalPair {

		int ht = -1;
		boolean isBal = true;
	}

	public boolean isBalanced2() {
		return isBalanced2(this.root).isBal;
	}

	private BalPair isBalanced2(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalanced2(node.left);
		BalPair rbp = isBalanced2(node.right);

		BalPair np = new BalPair();
		np.ht = Math.max(lbp.ht, rbp.ht) + 1;

		int bf = Math.abs(lbp.ht - rbp.ht);

		if (lbp.isBal && rbp.isBal && (bf == 0 || bf == 1)) {
			np.isBal = true;
		} else {
			np.isBal = false;
		}

		return np;
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		// node
		System.out.print(node.data + " ");

		// left
		preorder(node.left);

		// right
		preorder(node.right);

	}

	private class Pair {

		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {

		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.node = this.root;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}

			if (tp.sd == false) {
				System.out.print(tp.node.data + " ");
				tp.sd = true;
			} else if (tp.ld == false) {

				Pair np = new Pair();
				np.node = tp.node.left;
				stack.addFirst(np);

				tp.ld = true;
			} else if (tp.rd == false) {
				Pair np = new Pair();
				np.node = tp.node.right;
				stack.addFirst(np);

				tp.rd = true;
			} else {
				stack.removeFirst();
			}

		}

	}

	private class BSTPair {

		boolean isBST;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	}

	public boolean isBST() {
		return isBST(this.root).isBST;
	}

	private BSTPair isBST(Node node) {

		if (node == null) {
			BSTPair bp = new BSTPair();
			bp.isBST = true;
			return bp;
		}

		BSTPair lp = isBST(node.left);
		BSTPair rp = isBST(node.right);

		BSTPair sp = new BSTPair();

		sp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		if (node.data > lp.max && node.data < rp.min && lp.isBST && rp.isBST) {
			sp.isBST = true;
		} else {
			sp.isBST = false;
		}

		return sp;

	}

	private class VOPair {

		Node node;
		int hlevel;
		int vlevel;

		@Override
		public String toString() {
			return this.node.data + "";
		}

	}

	public void verticalOrderDisplay() {

		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();

		verticalOrderDisplay(this.root, map, 0, 0);

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());

		Collections.sort(keys);

		for (Integer key : keys) {
			ArrayList<VOPair> list = map.get(key);

			Collections.sort(list, new VOPairComparator());

			System.out.println(key + " -> " + list);
		}

	}

	private void verticalOrderDisplay(Node node, HashMap<Integer, ArrayList<VOPair>> map, int hl, int vl) {

		if (node == null) {
			return;
		}

		VOPair np = new VOPair();
		np.node = node;
		np.hlevel = hl;
		np.vlevel = vl;

		if (!map.containsKey(vl)) {
			map.put(vl, new ArrayList<>());
		}

		map.get(vl).add(np);

		verticalOrderDisplay(node.left, map, hl + 1, vl - 1);
		verticalOrderDisplay(node.right, map, hl + 1, vl + 1);

	}

	private class VOPairComparator implements Comparator<VOPair> {

		@Override
		public int compare(VOPair o1, VOPair o2) {
			return o1.hlevel - o2.hlevel;
		}

	}

	public void kFar(int k, int data) {
		kFar(this.root, k, data);
	}

	private int kFar(Node node, int k, int data) {

		if (node == null) {
			return -1;
		}

		if (node.data == data) {
			kDown(node, k, 0);
			return 0;
		}

		int ld = kFar(node.left, k, data);

		if (ld != -1) {

			if (ld + 1 == k) {
				System.out.println(node.data);
			}

			kDown(node.right, k - ld - 2, 0);

			return ld + 1;
		}

		int rd = kFar(node.right, k, data);
		if (rd != -1) {

			if (rd + 1 == k) {
				System.out.println(node.data);
			}

			kDown(node.left, k - rd - 2, 0);

			return rd + 1;
		}

		return -1;

	}

	private void kDown(Node node, int k, int count) {

		if (node == null) {
			return;
		}

		if (k == count) {
			System.out.println(node.data);
			return;
		}

		kDown(node.left, k, count + 1);
		kDown(node.right, k, count + 1);

	}

}
