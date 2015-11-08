public class SearchRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchRange sr = new SearchRange();
		System.out.print(sr.searchRange(new int[] { 2, 2 }, 1)[0]);
		System.out.print(sr.searchRange(new int[] { 2, 2 }, 1)[1]);
	}

	public int[] searchRange(int[] A, int target) {
		int n = A.length, left = -1, right = -1;
		left = findLeft(A, target, 0, n - 1);
		right = findRight(A, target, 0, n - 1);
		return new int[] { left, right };
	}

	private int findLeft(int A[], int target, int s, int e) {
		while (s < e) {
			int mid = s + (e - s) / 2;
			if (A[mid] < target) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		return A[s] == target ? s : -1;
	}

	private int findRight(int A[], int target, int s, int e) {
		while (s < e) {
			int mid = s + (e - s + 1) / 2;
			if (A[mid] > target) {
				e = mid - 1;
			} else {
				s = mid;
			}
		}
		return A[e] == target ? e : -1;
	}

}
