public class LongestPalindromeSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
		System.out.println(lps.longestPalindrome("aaabaaaa"));
	}

	public String longestPalindrome(String s) {
		// return solveN2(s); //time: O(N^2), space: O(1)
		return solveDP(s); // time: O(N^2), space: O(N^2)
	}

	private String solveDP(String s) {
		int len = s.length(), maxLen = 1, start = 0;
		boolean[][] dp = new boolean[len][len]; // just use the upperright
												// corner
		for (int i = 0; i < len; i++)
			dp[i][i] = true;
		for (int i = 0; i < len - 1; i++)
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				maxLen = 2;
				start = i;
			}

		for (int l = 3; l <= len; l++) {
			for (int i = 0; i <= len - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					maxLen = l;
					start = i;
				}
			}
		}
		return s.substring(start, start + maxLen);

	}

	private String solveN2(String s) {
		int len = s.length(), maxLen = 0, start = 0;
		if (len < 2)
			return s;

		for (int i = 0; i < len; i++) {
			if (isPalindrome(s, i - maxLen, i)) {
				start = i - maxLen;
				maxLen++;
			} else if (i - maxLen - 1 >= 0
					&& isPalindrome(s, i - maxLen - 1, i)) {
				start = i - maxLen - 1;
				maxLen += 2;
			}
		}
		return s.substring(start, start + maxLen);
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j)
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		return true;
	}

}
