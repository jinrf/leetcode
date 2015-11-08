public class RangeBitwiseAnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RangeBitwiseAnd rba = new RangeBitwiseAnd();
		System.out.println(rba.rangeBitwiseAnd(3, 3));
	}

	public int rangeBitwiseAnd(int m, int n) {
		
		

		long low = 1, high = 2;

		while (high <= n && low <= m) {
			low <<= 1;
			high <<= 1;
		}

		if (low <= m && high >= n)
			return (int) low;
		else
			return 0;

	}

}
