package L5_Dec15;

import java.util.Scanner;

import javax.tools.Diagnostic;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2018
 *
 */

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] arr = takeInput();

		// int[][] arr = { { 10, 20, 30, 40, 50 }, { 60, 70, 80, 90, 100 }, { 110, 120,
		// 130, 140, 150 },
		// { 160, 170, 180, 190, 200 } };
		// display(arr);
		// waveDisplay(arr);
		// spiralDisplay(arr);

		int[][] one = { { 1 }, { 1 }, { 1 } };
		int[][] two = { { 1, 1, 1 } };

		display(matrixMultiplication(one, two));
	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();

		int[][] arr = new int[rows][];

		for (int row = 0; row < arr.length; row++) {

			System.out.println("Cols for " + row + " ?");
			int cols = scn.nextInt();

			arr[row] = new int[cols];

			for (int col = 0; col < arr[row].length; col++) {
				System.out.println("[" + row + "-" + col + "] ?");
				arr[row][col] = scn.nextInt();
			}
		}

		return arr;

	}

	public static void display(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}

			System.out.println();
		}

	}

	public static void waveDisplay(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {

			if (col % 2 == 0) {

				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + " ");
				}
			}
		}

	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int count = 0;
		int nel = arr.length * arr[0].length;

		while (count < nel) {

			// first col
			for (int row = minRow; row <= maxRow && count < nel; row++) {
				System.out.print(arr[row][minCol] + " ");
				count++;
			}
			minCol++;

			// last row
			for (int col = minCol; col <= maxCol && count < nel; col++) {
				System.out.print(arr[maxRow][col] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int row = maxRow; row >= minRow && count < nel; row--) {
				System.out.print(arr[row][maxCol] + " ");
				count++;
			}
			maxCol--;

			// first row
			for (int col = maxCol; col >= minCol && count < nel; col--) {
				System.out.print(arr[minRow][col] + " ");
				count++;
			}
			minRow++;

		}
	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;

		// matrix multiplication not possible
		if (c1 != r2) {
			return null;
		}

		// logic goes here ...

		int[][] ans = new int[r1][c2];

		for (int i = 0; i < ans.length; i++) {

			for (int j = 0; j < ans[0].length; j++) {

				int sum = 0;
				for (int k = 0; k < c1; k++) {
					sum = sum + (one[i][k] * two[k][j]);
				}

				ans[i][j] = sum;
			}
		}

		return ans;

	}

}
