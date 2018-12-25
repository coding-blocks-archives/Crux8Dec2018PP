package L10_Dec25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Dec-2018
 *
 */

public class BackTracking {

	public static void main(String[] args) {

		// NQueen(new boolean[4][4], 0, "");
		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze.length]);
	}

	public static void NQueen(boolean[][] board, int row, String asf) {

		if (row == board.length) {
			System.out.println(asf);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				NQueen(board, row + 1, asf + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}

	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}

		return true;
	}

	public static void blockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length-1 && col == maze[0].length-1) {
			System.out.println(ans);
			return;
		}

		if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || visited[row][col]
				|| maze[row][col] == 1) {
			return;
		}

		visited[row][col] = true;
		blockedMaze(maze, row + 1, col, ans + "B", visited);
		blockedMaze(maze, row - 1, col, ans + "T", visited);
		blockedMaze(maze, row, col - 1, ans + "L", visited);
		blockedMaze(maze, row, col + 1, ans + "R", visited);
		visited[row][col] = false;

	}
}
