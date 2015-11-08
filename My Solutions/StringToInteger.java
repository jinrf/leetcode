public class StringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		atoi("-1");
	}

	public static int atoi(String str) {
		int len = str.length();
		if (len == 0)
			return 0;
		int i = 0;
		while (str.charAt(i) == ' ')
			i++;
		boolean isNeg = false;
		if (str.charAt(i) == '-') {
			isNeg = true;
			i++; // skip the sign
		}
		if (str.charAt(i) == '+')
			i++;

		if (len > 10) {
			return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}

		long result = 0;
		for (int j = i; j < str.length(); j++) {
			result *= 10;
			result += (int) (str.charAt(j) - '0');
			if (isNeg && -result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			else if (!isNeg && result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}

		return isNeg ? (int) -result : (int) result;
	}

}
