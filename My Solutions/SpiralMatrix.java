import java.util.*;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> ret = sm.spiralOrder(new int[][]{{2,3}});
		return;

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new LinkedList<>();
		int nRow = matrix.length;
		if (nRow == 0)
			return ret;
		int nCol = matrix[0].length;
		int rs = 0, re = nRow - 1, cs = 0, ce = nCol - 1;

		while (ret.size() < nRow * nCol) {
			for (int i = cs; i <= ce; i++) {
				ret.add(matrix[rs][i]);
			}
			rs++;

			for (int i = rs; i <= re; i++) {
				ret.add(matrix[i][ce]);
			}
			ce--;

			for (int i = ce; i >= cs; i--) {
				ret.add(matrix[re][i]);
			}
			re--;

			for (int i = re; i >= rs; i--) {
				ret.add(matrix[i][cs]);
			}
			cs++;
		}
		return ret;
	}

}
