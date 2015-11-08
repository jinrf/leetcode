public class RotatedSortedArray {

	public static void main(String[] args) {

		RotatedSortedArray rsa = new RotatedSortedArray();

		int[] array = {2,3,4,5,1};

		System.out.println(rsa.search(array, 1));
	}

	public int search(int[] A, int target) {

		switch (A.length) {
		case 0:
			return -1;
		case 1:
			if (A[0] == target) {
				return 0;
			} else {
				return -1;
			}
		case 2:
			if (A[0] == target) {
				return 0;
			} else if (A[1] == target) {
				return 1;
			} else {
				return -1;
			}
		default:

			int pivot = findPivot(A, 0, A.length - 1);
			System.out.println("pivot:" + pivot);

			if (pivot == -1) {
				return binarySearch(A, target, 0, A.length - 1);
			} else {
				int first = binarySearch(A, target, 0, pivot - 1);
				if (first == -1) {
					return binarySearch(A, target, pivot, A.length - 1);
				} else {
					return first;
				}
			}
		}
	}

	public int binarySearch(int[] A, int target, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;

	}

	public int findPivot(int[] A, int lo, int hi) {

		while (lo <= hi) {

			if (lo == hi || A[lo] < A[hi])
				return lo;

			if (1 == hi - lo)
				return A[lo] > A[hi] ? hi : lo;

			int mid = (lo + hi) / 2;
			if (A[mid - 1] > A[mid] && mid - 1 == lo)
				return mid;
			if (A[mid - 1] > A[mid] && mid == hi)
				return mid;
			if (A[mid - 1] > A[mid] && A[mid] < A[mid + 1])
				return mid;
			if (A[lo] < A[mid] && A[mid] > A[hi])
				lo = mid + 1;
			if (A[lo] > A[mid] && A[mid] < A[hi])
				hi = mid - 1;
		}

		return -1;

	}
}
