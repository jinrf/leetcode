public class MaximalSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximalSquare ms = new MaximalSquare();
		System.out.println(ms.maxSquare(new int[][] { { 1, 0, 1, 0, 0 },
				{ 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } }));
	}

	public int maxSquare(int[][] matrix) {
		int nRow = matrix.length;
		if (nRow == 0)
			return 0;
		int nCol = matrix[0].length;

		int[][] dp = new int[nRow + 1][nCol + 1];
		int max = 0;

		for (int i = 1; i <= nRow; i++) {
			for (int j = 1; j <= nCol; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
							dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max * max;
	}
}
