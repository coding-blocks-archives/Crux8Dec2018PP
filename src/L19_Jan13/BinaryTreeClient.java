package L19_Jan13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jan-2019
 *
 */

public class BinaryTreeClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false false

	// diameter
	// 10 true 20 true 30 true 40 true 50 false false false false true 60 false true
	// 70 false true 80 false false true 90 false false
	public static void main(String[] args) {

		int[] pre = { 10, 20, 40, 30, 50, 60, 70 };
		int[] in = { 20, 40, 10, 60, 50, 70, 30 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		System.out.println(bt.ht());
		System.out.println(bt.find(20));
		System.out.println(bt.max());
		System.out.println(bt.size());
		System.out.println(bt.diameter());
		System.out.println(bt.diameter2());
		System.out.println(bt.isBalanced());
		System.out.println(bt.isBalanced2());
		bt.preorder();
		bt.preorderI();

		
	}

}
