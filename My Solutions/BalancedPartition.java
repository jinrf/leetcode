public class BalancedPartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BalancedPartition bp = new BalancedPartition();
		System.out.println(bp.partition(new int[] { 3, 1, 5, 9, 12 }));

	}

	public boolean partition(int[] nums) {

		int sum = 0;
		for (int n : nums)
			sum += n;

		boolean[][] dp = new boolean[nums.length][sum / 2 + 1];

		for (int i = 0; i < nums.length; i++) {
			dp[i][nums[i]] = true;
			dp[i][0] = true;
			if (i == 0)
				continue;
			for (int j = nums[i]; j <= sum / 2; j++) {
				dp[i][j] = (dp[i - 1][j] || dp[i][j - nums[i]]);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (dp[i][sum / 2])
				return true;
		}
		return false;
	}
}
