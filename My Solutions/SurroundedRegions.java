import java.util.*;

public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] test = new char[][] { { 'O', 'X', 'O', 'O', 'X', 'X' },
				{ 'O', 'X', 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'O', 'X', 'O', 'O' },
				{ 'X', 'O', 'X', 'X', 'X', 'X' },
				{ 'O', 'O', 'X', 'O', 'X', 'X' },
				{ 'X', 'X', 'O', 'O', 'O', 'O' } };
		solve(test);
		System.out.print(test);
	}

	private static int height;
	private static int width;

	public static void solve(char[][] board) {

		if (board == null || board.length == 0)
			return;
		height = board.length;
		width = board[0].length;
		if (height == 1 && width == 1)
			return;

		// check borders
		// from top
		for (int i = 0; i < width; i++) {
			if (board[0][i] == 'O') {
				dfsMark(board, 0, i);
			}
		}
		// from bottom
		for (int i = height - 1; i < width; i++) {
			if (board[height - 1][i] == 'O') {
				dfsMark(board, height - 1, i);
			}
		}
		// from left
		for (int i = 0; i < height; i++) {
			if (board[i][0] == 'O') {
				dfsMark(board, i, 0);
			}
		}
		// from right
		for (int i = 0; i < height; i++) {
			if (board[width - 1][i] == 'O') {
				dfsMark(board, width - 1, i);
			}
		}
		// final round
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == 'U')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	private static void dfsMark(char[][] board, int x, int y) {

		Stack<Point> s = new Stack<Point>();
		s.push(new Point(x, y));

		while (!s.isEmpty()) {
			Point p = s.pop();
			board[p.x][p.y] = 'U';

			if (p.x - 1 > 0 && board[p.x - 1][p.y] == 'O') {
				s.push(new Point(p.x - 1, p.y));
			}

			if (p.x + 1 < height && board[p.x + 1][p.y] == 'O') {
				s.push(new Point(p.x + 1, p.y));
			}

			if (p.y - 1 > 0 && board[p.x][p.y - 1] == 'O') {
				s.push(new Point(p.x, p.y - 1));
			}

			if (p.y + 1 < width && board[p.x][p.y + 1] == 'O') {
				s.push(new Point(p.x, p.y + 1));
			}

		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
