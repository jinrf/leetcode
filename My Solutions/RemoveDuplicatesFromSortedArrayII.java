public class RemoveDuplicatesFromSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] A) {
		int len = A.length;
		if (len < 3)
			return len;

		int i = 0;
		int count = 1;
		for (int j = 2; j < len; j++) {
			if (A[j] != A[i] && count < 2) {
				i++;
				A[i] = A[j];
				count = 1;
			} else if (A[j] == A[i] && count < 2) {
				count++;
				i++;
			}
		}

		return 0;

	}
}
