public class KthLargestElementInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KthLargestElementInAnArray k = new KthLargestElementInAnArray();
		System.out.println(k.findKthLargest(new int[] { 7, 6, 5, 4, 3, 2, 1 },
				2));

	}

	public int findKthLargest(int[] nums, int k) {
		return findKth(nums, 0, nums.length - 1, nums.length + 1 - k);
	}

	private int findKth(int[] nums, int s, int e, int k) {

		if (e - s + 1 == 1 && k == 1)
			return nums[s];

		int nLeft = partition(nums, s, e, k); // including pivot
		if (nLeft > k)
			return findKth(nums, s, s + nLeft - 2, k);
		else if (nLeft < k)
			return findKth(nums, s + nLeft, e, k - nLeft);
		else
			return nums[s + nLeft - 1];
	}

	private int partition(int[] nums, int l, int r, int k) {
		int pivot = nums[r];
		int pos = l;
		for (int i = l; i < r; i++) {
			if (nums[i] < pivot) {
				int tmp = nums[pos];
				nums[pos] = nums[i];
				nums[i] = tmp;
				pos++;
			}
		}

		int tmp = nums[pos];
		nums[pos] = pivot;
		nums[r] = tmp;

		return pos - l + 1;
	}
}