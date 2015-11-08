public class SearchInRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(search(new int[] { 3,4,5,6,1,2}, 2));
	}

	public static int search(int[] A, int target) {

		int i = 0, j = A.length - 1;

		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (A[mid] == target)
				return mid;
			if (A[i] <= A[mid]) {
				if (A[i] <= target && target < A[mid]) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}

			} else {
				if (A[mid] < target && target <= A[j]) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			}
		}
		return -1;
	}

}
