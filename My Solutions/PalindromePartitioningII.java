public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromePartitioningII pp2 = new PalindromePartitioningII();
		pp2.minCut("bb");
	}

	public int minCut(String s) {

		int len = s.length();
		int[] t = new int[len + 1]; // DP table

		for (int i = 0; i <= len; i++)
			t[i] = i - 1; // let t[0] = -1 for consistency
		for (int i = 0; i < len; i++) {
			for (int j = 0; i - j >= 0 && i + j < len
					&& s.charAt(i - j) == s.charAt(i + j); j++)
				t[i + j + 1] = Math.min(t[i + j + 1], 1 + t[i - j]);

			for (int j = 0; i - j >= 0 && i + j + 1 < len
					&& s.charAt(i - j) == s.charAt(i + j + 1); j++)
				t[i + j + 2] = Math.min(t[i + j + 2], 1 + t[i - j]);
		}
		return t[len];
	}
}
