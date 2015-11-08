import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximalRectangle mr = new MaximalRectangle();
		System.out.println(mr.maximalRectangle(new char[][] { { '1', '1' } }));

	}

	public int maximalRectangle(char[][] matrix) {

		// return sol1(matrix);
		return sol2(matrix);
	}

	private int sol2(char[][] matrix) {
		int nRow = matrix.length;
		if (nRow == 0)
			return 0;
		int nCol = matrix[0].length;
		int maxArea = 0;
		int[] height = new int[nCol + 1]; // add a virtual right column

		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}

			Stack<Integer> s = new Stack<>();
			int j = 0;
			while (j <= nCol) {
				if (s.isEmpty() || height[j] > height[s.peek()])
					s.push(j++);
				else {
					int h = height[s.pop()];
					int area = h * (s.isEmpty() ? j : (j - s.peek() - 1));
					maxArea = Math.max(area, maxArea);
				}
			}
		}

		return maxArea;
	}

	private int sol1(char[][] matrix) {
		int nRow = matrix.length;
		if (nRow == 0)
			return 0;
		int nCol = matrix[0].length;
		int maxArea = 0;

		int[] left = new int[nCol], right = new int[nCol], height = new int[nCol];
		Arrays.fill(right, nCol);
		for (int i = 0; i < nRow; i++) {
			int curr_left = 0, curr_right = nCol;
			for (int j = 0; j < nCol; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < nCol; j++) {
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], curr_left);
				else {
					left[j] = 0;
					curr_left = j + 1;
				}
			}
			for (int j = nCol - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], curr_right);
				else {
					right[j] = nCol;
					curr_right = j;
				}
			}
			for (int j = 0; j < nCol; j++)
				maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
		}
		return maxArea;
	}

}
