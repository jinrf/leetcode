public class HouseRobber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(new int[] { 1, 2 }));
	}

	public int rob(int[] nums) {

		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[0], nums[1]);

		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]); 
		for (int i = 2; i < len - 1; i++)
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

		int max1 = dp[len - 2];

		dp[0] = 0;
		dp[1] = nums[1];
		dp[2] = Math.max(nums[1], nums[2]);

		for (int i = 2; i < nums.length; i++)
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

		return Math.max(max1, dp[len - 1]);

	}
}
