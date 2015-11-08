public class MinimumSizeSubarraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
		System.out.println(msss.minSubArrayLen(5, new int[] { 2, 3, 1, 1, 1, 1,
				1 }));
		return;
	}

	public int minSubArrayLen(int s, int[] nums) {
		return solveNLogN(s, nums);
	}

	private int solveNLogN(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int[] sums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				sums[i] = nums[i];
			else
				sums[i] = sums[i - 1] + nums[i];
		}
		for (int j = 0; j < nums.length; j++) {
			if (sums[j] < s)
				continue;
			int i = binarySearch(0, j, sums[j] - s, sums);
			min = Math.min(min, j - i);
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	// find the rightmost that <= key
	private int binarySearch(int start, int end, int key, int[] nums) {
		int i = start, j = end;
		while (i < j) {
			int mid = (int) (i + Math.ceil((j - i) / 2.0));
			if (nums[mid] > key)
				j = mid - 1;
			else
				i = mid;
		}
		return i;
	}

	private int solveN(int s, int[] nums) {
		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		while (i <= j && j < nums.length) {
			while (j < nums.length && sum < s) {
				sum += nums[j++];
			}
			if (sum < s)
				break; // good!
			while (i <= j && sum >= s) {
				min = Math.min(min, j - i);
				sum -= nums[i++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
