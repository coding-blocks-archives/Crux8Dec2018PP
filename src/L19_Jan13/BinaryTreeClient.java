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

		// int[] pre = { 10, 20, 40, 30, 50, 60, 70 };
		// int[] in = { 20, 40, 10, 60, 50, 70, 30 };

		// int[] in = { 3, 5, 7, 10, 16, 20, 25 };
		// int[] pre = { 10, 5, 3, 7, 20, 16, 25 };

		int[] in = { 40, 20, 100, 50, 80, 10, 70, 30, 90 };
		int[] pre = { 10, 20, 40, 50, 100, 80, 30, 70, 90 };

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

		System.out.println(bt.isBST());

		bt.verticalOrderDisplay();

		bt.kFar(2, 20);

	}

}
