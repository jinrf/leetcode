import java.util.*;

public class NQueen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueen nq = new NQueen();

		List<String[]> sol = nq.solveNQueens(1);
		return;

	}

	private boolean[] column, diag, diagx;
	private int nRow;
	private List<String[]> res;
	private int[] queen;

	public List<String[]> solveNQueens(int n) {

		res = new ArrayList<>();
		nRow = n;
		column = new boolean[n];
		diag = new boolean[2 * n + 1];
		diagx = new boolean[2 * n - 1];
		queen = new int[n];

		DFS(1);
		return res;
	}

	private void DFS(int n) {
		if (n > nRow) {
			res.add(genSolution());
			return;
		}

		for (int i = 0; i < nRow; i++) {
			if (column[i] || diag[i + n - 1] || diagx[n + nRow - i - 2]) {
				continue;
			} else {
				column[i] = diag[i + n - 1] = diagx[n + nRow - i - 2] = true;
				queen[n - 1] = i;
				DFS(n + 1);
				column[i] = diag[i + n - 1] = diagx[n + nRow - i - 2] = false;
			}
		}
	}

	private String[] genSolution() {
		String[] sol = new String[nRow];
		for (int i = 0; i < nRow; i++) {
			StringBuilder s = new StringBuilder();
			for (int j = 0; j < nRow; j++) {
				if (queen[i] == j) {
					s.append('Q');
				} else
					s.append('.');
			}
			sol[i] = s.toString();
		}
		return sol;
	}

}
