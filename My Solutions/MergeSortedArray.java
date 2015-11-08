public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		
		
		int lenA = A.length;

		for (int i = 0; i < m; i++) {
			A[lenA - 1 - i] = A[m - 1 - i];
		}

		int ia = n, ib = 0, ic = 0;
		while (ia < m + n && ib < n) {
			if (A[ia] <= B[ib]) {
				A[ic++] = A[ia++];
			} else {
				A[ic++] = A[ib++];
			}
		}

		if (ia > m + n) {
			while (ib < n) {
				A[ic++] = A[ib++];
			}
		} else {
			while (ia < m + n) {
				A[ic++] = A[ia++];
			}
		}

	}
}
