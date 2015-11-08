public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		fmp.firstMissingPositive(new int[] { 2, 1 });

	}

	public int firstMissingPositive(int[] A) {
		int len = A.length;
		int i = 0;
		while (i < len) {
			if (A[i] > 0 && A[i] <= len && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
				int tmp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = tmp;
			} else {
				i++;
			}
		}

		for (i = 0; i < len; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return len + 1; // all fit
	}
}
