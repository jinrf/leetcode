public class SudokuSolver {

	public static void main(String[] args) {
		SudokuSolver ss = new SudokuSolver();
		char[][] myboard = new char[][] {
				{ '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' }, };
		ss.solveSudoku(myboard);
		return;
	}

	private char[][] board;

	public void solveSudoku(char[][] board) {
		this.board = board;
		boolean ret = solve(0);
		return;
	}

	private boolean solve(int loc) {
		if (loc == 81)
			return true; // all done
		int row = loc / 9, col = loc % 9;
		if (board[row][col] != '.')
			return solve(loc + 1);
		for (char c = '1'; c <= '9'; c++) {
			board[row][col] = c;
			if (isValid(row, col) && solve(loc + 1)) {
				return true;
			}
			board[row][col] = '.';
		}
		return false;
	}

	private boolean isValid(int row, int col) {
		char c = board[row][col];

		for (int i = 0; i < 9; i++) {
			if (i != col && board[row][i] == c) // check row
				return false;

			if (i != row && board[i][col] == c) // check col
				return false;
		}

		// check block
		int sx = row / 3 * 3;
		int sy = col / 3 * 3;

		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (i != row && j != col && board[i][j] == c)
					return false;
			}
		}
		return true;
	}
}
