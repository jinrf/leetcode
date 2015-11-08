public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101,
				18 }));
	}

	public int lengthOfLIS(int[] nums) {
		int len = 0;
		int[] a = new int[nums.length];
		for (int n : nums) {
			int j = search(nums, 0, len - 1, n);
			a[j] = n;
			if (j == len)
				len++;
		}
		return len;
	}

	// find the first one that is smaller than n
	private int search(int[] nums, int l, int r, int key) {
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (nums[m] >= key)
				r = m - 1;
			else
				l = m + 1;
		}
		return l;
	}

}
