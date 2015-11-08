public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(new char[][] { 
				{ 'a', 'b', 'c', 'e' },
				{ 's', 'f', 'c', 's' }, 
				{ 'a', 'd', 'e', 'e' } }, "asadeb"));

	}

	String word;
	char[][] board;
	boolean[][] flag;
	int len = 0;
	int nRow = 0;
	int nCol = 0;

	public boolean exist(char[][] board, String word) {
		len = word.length();
		this.word = word;
		this.board = board;
		nRow = board.length;
		if (len == 0)
			return true;
		if (nRow == 0)
			return false;
		if (nRow > 0) {
			nCol = board[0].length;
			if (nRow * nCol < len)
				return false;
			flag = new boolean[nRow][nCol];
		}

		for (int i = 0; i < nRow; i++)
			for (int j = 0; j < nCol; j++)
				if (find(1, i, j))
					return true;
		return false;
	}

	private boolean find(int k, int x, int y) {
		if (k == len)
			return true;
		if (x < 0 || x >= nRow || y < 0 || y >= nCol || flag[x][y]
				|| word.charAt(k) != board[x][y])
			return false;
		flag[x][y] = true;
		if (find(k + 1, x - 1, y) || find(k + 1, x + 1, y)
				|| find(k + 1, x, y - 1) || find(k + 1, x, y + 1))
			return true;
		flag[x][y] = false;
		return false;
	}

}
