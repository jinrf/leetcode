public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[] { 1, 2, 3 }, 1));
	}

	public static int searchInsert(int[] A, int target) {
		int len = A.length;
		if (len == 0 || target < A[0])
			return 0;
		if (target > A[len - 1])
			return len;

		int i = 0, j = len - 1;

		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] > target)
				j = mid - 1;
			else if (A[mid] < target)
				i = mid + 1;
		}

		return i;
	}

}