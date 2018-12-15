package L5_Dec15;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2018
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][5];

		System.out.println(arr);
		System.out.println("Rows " + arr.length);
		System.out.println("Cols " + arr[0].length);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr[1][4]);
		arr[1][4] = 100;
		System.out.println(arr[1][4]);

		System.out.println(" -- Jagged Array -- ");
		int[][] jarr = new int[3][];
		System.out.println(jarr);
		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[2];
		jarr[1] = new int[5];
		jarr[2] = new int[4];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

	}

}
