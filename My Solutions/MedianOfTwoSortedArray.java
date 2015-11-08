import java.util.Arrays;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { 1, 2 };
		System.out.println(findMedianSortedArrays(A, B));
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		// return sol1(A, B);

		int m = A.length, n = B.length;
		if (m == 0) return (B[n / 2] + B[(n - 1) / 2]) / 2;
		if (n == 0) return (A[n / 2] + A[(n - 1) / 2]) / 2;
		
		if (m > n)
			return sol2(B, A, Math.max(0, (n - m) / 2 - 1),
					Math.min(n - 1, (m + n) / 2) - 1);
		else
			return sol2(A, B, Math.max(0, (m - n) / 2 - 1),
					Math.min(m - 1, (m + n) / 2 - 1));

	}

	private static double sol2(int A[], int B[], int left, int right) {
		int m = A.length, n = B.length;
		int i = (left + right) / 2;
		int j = (m + n) / 2 - (i + 1) - 1;

		if ((j == -1 || A[i] > B[j]) && (j == m - 1 || A[i] <= B[j + 1]))
			return A[i];
		else if ((j == -1 || A[i] > B[j]) && (j != m - 1 || A[i] > B[j + 1]))
			return sol2(A, B, left, i - 1);
		else
			return sol2(A, B, i + 1, right);
	}

	private static double sol1(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		return (double) (findKth(A, 0, lenA - 1, B, 0, lenB - 1,
				(lenA + lenB) / 2) + findKth(A, 0, lenA - 1, B, 0, lenB - 1,
				(lenA + lenB - 1) / 2)) / 2;
	}

	private static int findKth(int A[], int leftA, int rightA, int B[],
			int leftB, int rightB, int k) {
		int lenA = leftA > rightA ? 0 : rightA - leftA + 1;
		int lenB = leftB > rightB ? 0 : rightB - leftB + 1;

		if (lenA == 0) {
			return B[leftB + k];
		} else if (lenB == 0) {
			return A[leftA + k];
		}

		int midAPos = lenA / 2;
		int midBPos = lenB / 2;
		int midAVal = A[leftA + midAPos];
		int midBVal = B[leftB + midBPos];

		if (midAPos + midBPos < k) {
			if (midAVal > midBVal) {
				return findKth(A, leftA, rightA, B, leftB + midBPos + 1,
						rightB, k - midBPos - 1);
			} else {
				return findKth(A, leftA + midAPos + 1, rightA, B, leftB,
						rightB, k - midAPos - 1);
			}
		} else {
			if (midAVal > midBVal) {
				return findKth(A, leftA, leftA + midAPos - 1, B, leftB, rightB,
						k);
			} else {
				return findKth(A, leftA, rightA, B, leftB, leftB + midBPos - 1,
						k);
			}
		}
	}

}
