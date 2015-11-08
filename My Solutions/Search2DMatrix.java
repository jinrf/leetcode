public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix, 10));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null) {
			return false;
		}

		int lowRow = 0, highRow = matrix.length - 1;
		int lowCol = 0, highCol = matrix[0].length - 1;

		if (matrix[lowRow][0] > target || matrix[highRow][highCol] < target) {
			return false;
		}

		while (lowRow < highRow) {
			int midRow = (lowRow + highRow) / 2;

			if (matrix[midRow][highCol] == target) {
				return true;
			}
			if (matrix[midRow][0] < target) {
				lowRow = midRow;
			}
			if (matrix[midRow][highCol] < target) {
				lowRow = midRow + 1;
			}
			if (matrix[midRow][0] > target) {
				highRow = midRow - 1;
			}
			if (matrix[midRow][highCol] > target) {
				highRow = midRow;
			}

		}

		while (lowCol <= highCol) {
			int midCol = (lowCol + highCol) / 2;
			if (matrix[lowRow][midCol] < target) {
				lowCol = midCol + 1;
			} else if (matrix[lowRow][midCol] > target) {
				highCol = midCol - 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
