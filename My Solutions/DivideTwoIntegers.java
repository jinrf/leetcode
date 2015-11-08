public class DivideTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DivideTwoIntegers dti = new DivideTwoIntegers();
		System.out.println(dti.divide2(2, 2));
	}

	public int divide2(int dividend, int divisor) {

		boolean isNegative = dividend >= 0 ^ divisor >= 0 ? true : false;

		Long dividendL = Math.abs((long) dividend);
		Long divisorL = Math.abs((long) divisor);

		if (divisorL == 0)
			return Integer.MAX_VALUE;
		if (divisorL == 1) {
			long tmp = isNegative ? -dividendL : dividendL;
			return tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE ? Integer.MAX_VALUE
					: (int) tmp;
		}

		int quotient = 0;
		while (dividendL >= divisorL) {
			long i = 1, div = divisorL;
			while (dividendL >> 2 >= div) {
				i <<= 1;
				div <<= 1;
			}
			dividendL -= div;
			quotient += i;
		}
		return isNegative ? -quotient : quotient;
	}

	public int divide(int dividend, int divisor) {

		boolean isNegative = false;
		if (dividend >= 0 ^ divisor >= 0)
			isNegative = true;
		Long dividendL = Math.abs((long) dividend);
		Long divisorL = Math.abs((long) divisor);

		if (divisorL == 0)
			return Integer.MAX_VALUE;
		if (divisorL == 1) {
			long tmp = isNegative ? -dividendL : dividendL;
			if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			} else {
				return (int) tmp;
			}
		}
		if (dividendL < divisorL)
			return 0;

		int r = 0;
		while (dividendL >= divisorL) {
			int i = 1;
			long tmp = divisorL;
			while (dividendL >= tmp) {
				dividendL -= tmp;
				r += i;
				tmp <<= 1;
				i <<= 1;
			}
		}
		return isNegative ? -r : r;
	}

}
