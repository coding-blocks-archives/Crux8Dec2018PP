package L17_Jan6;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Jan-2019
 *
 */

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0
		String str = "10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0";
		GenericTree gt = new GenericTree(str);
		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.find(50));
		System.out.println(gt.ht());
		// gt.mirror();
		gt.display();
		// gt.preorder();
		// gt.postorder();
		// gt.levelOrder();
		// gt.levelOrderLW();
		// gt.levelOrderZZ();
		//
		// gt.printAtLevel(2);

		gt.multiSolver(80);
	}

}
