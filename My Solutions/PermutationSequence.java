import java.util.*;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getPermutation(3, 4);

	}

	public static String getPermutation(int n, int k) {
		List<Integer> cand = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			cand.add(i);
		StringBuilder sb = new StringBuilder();
		k--;

		for (int i = n - 1; i >= 0; i--) {
			int pos = (int) Math.ceil(k / factorial(i));
			k %= factorial(i);
			sb.append(cand.get(pos));
			cand.remove(pos);
		}

		return sb.toString();
	}

	private static int factorial(int n) {
		int ret = 1;
		for (int i = 1; i < n; i++)
			ret *= i;
		return ret;
	}

}
