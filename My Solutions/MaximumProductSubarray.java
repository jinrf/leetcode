public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(maxProduct1(new int[] { -4, -3, -2 }));

	}

	public static int maxProduct1(int[] A) {
		int len = A.length;
		int max = A[0], min = A[0];
		int ret = A[0];

		for (int i = 1; i < len; i++) {
			if (A[i] < 0) {
				max = max ^ min;
				min = max ^ min;
				max = max ^ min;
			}

			max = Math.max(A[i], max * A[i]);
			min = Math.min(A[i], min * A[i]);
			ret = Math.max(ret, max);
			
		}
		return max;
	}

	public static int maxProduct(int A[]) {
		// store the result that is the max we have found so far
		int r = A[0];

		// imax/imin stores the max/min product of
		// subarray that ends with the current number A[i]
		for (int i = 1, imax = r, imin = r; i < A.length; i++) {
			// multiplied by a negative makes big number smaller, small number
			// bigger
			// so we redefine the extremums by swapping them
			if (A[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}

			// max/min product for the current number is either the current
			// number itself
			// or the max/min by the previous number times the current one
			imax = Math.max(A[i], imax * A[i]);
			imin = Math.min(A[i], imin * A[i]);

			// the newly computed max value is a candidate for our global result
			r = Math.max(r, imax);
		}
		return r;
	}

}
