public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(new int[] { 1, -1, 1 }));
	}

	public int maxSubArray(int[] nums) {
		return dnc(nums, 0, nums.length - 1);
	}

	private int dnc(int[] nums, int left, int right) { // divide and conquer
		int len = right - left + 1;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[left];

		int mid = left + (right - left) / 2;
		int leftMax = dnc(nums, left, mid);
		int rightMax = dnc(nums, mid + 1, right);

		return Math.max(leftMax + rightMax, Math.max(leftMax, rightMax));
	}
}
