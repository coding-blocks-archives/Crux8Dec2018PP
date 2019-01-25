package Assignments.Jan25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jan-2019
 *
 */

public class Sudoku {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int[][] board = new int[n][n];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = scn.nextInt();
			}

		}

		sudokuSolver(board, 0, 0);

	}

	public static boolean sudokuSolver(int[][] board, int row, int col) {

		if (row == board.length) {
			display(board);
			return true;
		}

		if (col >= board[0].length) {
			return sudokuSolver(board, row + 1, 0);
		}

		if (board[row][col] != 0) {
			return sudokuSolver(board, row, col + 1);
		}

		// self work
		for (int i = 1; i <= 9; i++) {

			if (isItSafe(board, row, col, i)) {
				board[row][col] = i;
				boolean res = sudokuSolver(board, row, col + 1);

				if (res) {
					return true;
				}

				board[row][col] = 0;
			}

		}

		return false;

	}

	private static void display(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");

	}

	public static boolean isItSafe(int[][] board, int row, int col, int val) {

		return isItSafeRow(board, row, val) && isItSafeCol(board, col, val) && isItSafe3X3Cell(board, row, col, val);
	}

	public static boolean isItSafeRow(int[][] board, int row, int val) {

		for (int col = 0; col < board[0].length; col++) {
			if (board[row][col] == val) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafeCol(int[][] board, int col, int val) {

		for (int row = 0; row < board[0].length; row++) {
			if (board[row][col] == val) {
				return false;
			}
		}

		return true;
	}

	public static boolean isItSafe3X3Cell(int[][] board, int row, int col, int val) {

		int sRow = row - row % 3;
		int sCol = col - col % 3;

		for (int i = sRow; i < sRow + 3; i++) {

			for (int j = sCol; j < sCol + 3; j++) {

				if (board[i][j] == val) {
					return false;
				}
			}
		}

		return true;

	}

}
