public class GameOfLive {

	public static void main(String[] args) {
		GameOfLive gol = new GameOfLive();
		int[][] board = new int[][] { 
				{ 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0 },
				{ 0, 1, 1, 0 }, 
				{ 0, 0, 0, 0 } };
		gol.gameOfLife(board);
		return;
	}

	public void gameOfLife(int[][] board) {

		int nRow = board.length;
		int nCol = board[0].length;

		// used the 2nd bit to indicate the new state. 0, dead to dead, 1-live
		// to dead, 2 - dead to live, 3 = live to live

		int[][] neighbors = new int[][] { { -1, -1 }, { 0, -1 }, { 1, -1 },
				{ -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				int nLive = 0;
				for (int[] n : neighbors) {
					if (i + n[0] < 0 || i + n[0] == nRow || j + n[1] < 0
							|| j + n[1] == nCol) // border cases
						continue;
					else if ((board[i + n[0]][j + n[1]] & 1) == 1)
						nLive++;
				}
				if (nLive == 2 || nLive == 3)
					board[i][j] |= 2; // set to live
			}
		}

		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				if ((board[i][j] & 2) == 2)
					board[i][j] = 1;
				else {
					board[i][j] = 0;
				}
			}
		}
	}
}
