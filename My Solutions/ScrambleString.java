public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("abb", "bba"));
	}

	public boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length())
			return false;

		// dp[i][j][l]: whether s2.substr(j,j+l) is a scrambled string of
		// s1.substr(i,i+l)
		boolean[][][] dp = new boolean[len + 1][len + 1][len + 1];

		for (int l = 1; l <= len; l++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
					for (int d = 1; d < l; d++) {
						dp[i][j][l] |= dp[0][0][d] && dp[d][d][l - d];
						dp[i][j][l] |= dp[0][l - d][d] && dp[d][0][l - d];
					}
				}
			}
		}

		return dp[0][0][len];
	}

}
