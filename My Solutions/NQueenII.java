import java.util.*;

public class NQueenII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueenII nq = new NQueenII();

		System.out.println(nq.totalNQueens(4));
		return;

	}

	private int nQueen;
	private boolean[] column, diag, diagx;
	private int[] queen;
	private int total = 0;

	public int totalNQueens(int n) {

		this.nQueen = n;
		this.column = new boolean[n];
		this.diag = new boolean[2 * n - 1];
		this.diagx = new boolean[2 * n - 1];
		this.queen = new int[n];

		DFS(1);
		return total;
	}

	private void DFS(int n) {
		if (n > nQueen) {
			total += 1;
			return;
		}

		for (int i = 0; i < nQueen; i++) {
			if (column[i] | diag[n - 1 + i] | diagx[n - 1 + nQueen - 1 - i]) {
				continue;
			} else {
				column[i] = diag[n - 1 + i] = diagx[n - 1 + nQueen - 1 - i] = true;
				queen[n - 1] = i;
				DFS(n + 1);
				column[i] = diag[n - 1 + i] = diagx[n - 1 + nQueen - 1 - i] = false;
			}
		}
	}

}
