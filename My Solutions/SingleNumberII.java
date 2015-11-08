public class SingleNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] A) {
		int[] count = new int[32];
		int res = 0;

		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				count[i] += (A[j] >> i & 1) == 1 ? 1 : 0;
				count[i] %= 3;
			}
			res |= count[i] << i;

		}

		return res;
	}

}
