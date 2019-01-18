package L10_Dec25;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Dec-2018
 *
 */

public class BackTracking {

	public static void main(String[] args) {

		// NQueen(new boolean[4][4], 0, "");
		// int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0
		// } };
		// blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze.length]);

		// nKnights(new boolean[3][3], 0, 0, "", 0);

		// nKnight2(new boolean[4][4], 0, 0, "", 0);
		// palindrome("nnitinn", "");
		// palindrome2("nnitinn", "", 0, 6);

		String[] dict = { "i", "like", "coding", "blocks", "codingblocks", "cod", "ing", "ilike" };

		String str = "ilikecodingblocks";
		wordBreak(dict, str, 0, str.length() - 1, "");

		System.out.println(palindromeAL("nnitin", 0, 5));

	}

	public static void NQueen(boolean[][] board, int row, String asf) {

		if (row == board.length) {
			System.out.println(asf);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeQueen(board, row, col)) {
				board[row][col] = true;
				NQueen(board, row + 1, asf + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}

	}

	public static boolean isItSafeQueen(boolean[][] board, int row, int col) {

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

		if (row == maze.length - 1 && col == maze[0].length - 1) {
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

	public static void nKnights(boolean[][] board, int row, int col, String ans, int kpsf) {

		if (kpsf == board.length) {
			System.out.println(ans);
			return;
		}

		// same row, rest of cols
		for (int c = col; c < board[0].length; c++) {

			if (isItSafeKnight(board, row, c)) {
				board[row][c] = true;
				nKnights(board, row, c + 1, ans + "{" + row + "-" + c + "}", kpsf + 1);
				board[row][c] = false;
			}
		}

		for (int r = row + 1; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {

				if (isItSafeKnight(board, r, c)) {
					board[r][c] = true;
					nKnights(board, r, c + 1, ans + "{" + r + "-" + c + "}", kpsf + 1);
					board[r][c] = false;
				}
			}

		}

	}

	public static boolean isItSafeKnight(boolean[][] board, int row, int col) {

		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { -2, -1, 1, 2 };

		for (int index = 0; index < 4; index++) {

			int nr = row + rowArr[index];
			int nc = col + colArr[index];

			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc]) {
				return false;
			}

		}

		return true;
	}

	public static void nKnight2(boolean[][] board, int row, int col, String ans, int kpsf) {

		if (kpsf == board.length) {
			System.out.println(ans);
			return;
		}

		if (row >= board.length) {
			return;
		}

		if (col >= board[0].length) {
			nKnight2(board, row + 1, 0, ans, kpsf);
			return;
		}

		if (isItSafeKnight(board, row, col)) {
			board[row][col] = true;
			nKnight2(board, row, col + 1, ans + "{" + row + "-" + col + "}", kpsf + 1);
			board[row][col] = false;
		}

		nKnight2(board, row, col + 1, ans, kpsf);

	}

	public static boolean isPalindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	// print approach
	public static void palindrome(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String word = ques.substring(0, i);

			if (isPalindrome(word)) {
				palindrome(ques.substring(i), ans + word + " ");
			}
		}

	}

	public static void palindrome2(String ques, int si, int ei, String ans) {

		if (si > ei) {
			System.out.println(ans);
			return;
		}

		for (int i = si + 1; i <= ei + 1; i++) {

			String word = ques.substring(si, i);

			if (isPalindrome(word)) {
				palindrome2(ques, i, ei, ans + word + " ");
			}
		}

	}

	// get approach
	public static ArrayList<ArrayList<String>> palindromeAL(String ques, int si, int ei) {

		if (si > ei) {
			ArrayList<ArrayList<String>> br = new ArrayList<>();
			br.add(new ArrayList<>());
			return br;
		}

		ArrayList<ArrayList<String>> mr = new ArrayList<>();

		for (int i = si + 1; i <= ei + 1; i++) {

			String word = ques.substring(si, i);

			if (isPalindrome(word)) {
				ArrayList<ArrayList<String>> rr = palindromeAL(ques, i, ei);

				for (ArrayList<String> rral : rr) {
					rral.add(0, word);
				}

				mr.addAll(rr);
			}
		}

		return mr;

	}

	public static void wordBreak(String[] dict, String ques, int si, int ei, String ans) {

		if (si > ei) {
			System.out.println(ans);
			return;
		}

		for (int i = si + 1; i <= ei + 1; i++) {

			String word = ques.substring(si, i);

			if (contains(dict, word)) {
				wordBreak(dict, ques, i, ei, ans + word + " ");
			}
		}

	}

	public static boolean contains(String[] dict, String word) {

		for (String val : dict) {

			if (val.equals(word)) {
				return true;
			}
		}

		return false;
	}

}
