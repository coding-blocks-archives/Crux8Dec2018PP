package L20_Jan19;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jan-2019
 *
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 40, 50, 60, 70 };

		BST bst = new BST(in);
		bst.display();
		System.out.println(bst.size());
		System.out.println(bst.ht());
		System.out.println(bst.find(60));
		System.out.println(bst.max());
		bst.printInRange(25, 65);
		// bst.replaceWithSumLarger();
		bst.display();
		bst.add(35);
		bst.display();
	}

}
