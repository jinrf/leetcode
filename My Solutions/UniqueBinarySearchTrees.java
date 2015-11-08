public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
		System.out.println(ubst.numTrees(19));
	}

	public int numTrees(int n) {
		//return dp(n);
		return recursive(1, n);
	}

	private int recursive(int start, int end) {
		if (start >= end)
			return 1;
		int sum = 0;
		for (int i = start; i <= end; i++) {
			int left = recursive(start, i - 1);
			int right = recursive(i + 1, end);
			sum += left * right;
		}
		return sum;
	}

	private int dp(int n) {
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;
		for (int i = 2; i <= n; i++)
			for (int j = 1; j <= i; j++)
				G[i] += G[j - 1] * G[i - j]; // G[j-1] left tree, G[i-j] - right
												// tree;
		return G[n];
	}

}
