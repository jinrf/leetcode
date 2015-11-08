public class UniquePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniquePath up = new UniquePath();
		up.uniquePaths(10, 10);
	}

	public int uniquePaths(int m, int n) {

		// essentially it is C(m+n-2, n-1): in total m+n-2 steps, choose n-1
		// step to go downward
		if (m < n)
			return uniquePaths(n, m); // swap

		int a = m + n - 2;
		int b = n - 1;

		double res = 1;

		for (int i = 1; i <= a; i++)
			res *= i;

		for (int i = 1; i <= b; i++)
			res /= i;

		for (int i = 1; i <= a - b; i++)
			res /= i;

		return (int)res;
	}

}
