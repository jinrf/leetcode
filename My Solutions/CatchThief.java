import java.util.Arrays;

public class CatchThief {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CatchThief ct = new CatchThief();
		System.out.println(ct.canCatch(
				new int[] { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 }, 5));
	}

	public boolean canCatch(int[] seq, int n) {

		boolean[] dp = new boolean[n + 2];
		Arrays.fill(dp, true);

		dp[0] = dp[seq[0]] = dp[n + 1] = false;

		for (int i = 0; i < seq.length; i++)
			for (int j = 1; j <= n; j++)
				dp[j] = ((dp[j - 1] || dp[j + 1]) && j != seq[i]);

		for (int i = 1; i <= n; i++)
			if (dp[i])
				return false;

		return true;
	}
}
