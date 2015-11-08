public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		np.nextPermutation(new int[] { 5, 1, 1 });
		return;
	}

	public void nextPermutation(int[] num) {
		int n = num.length;
		if (n < 2)
			return;

		int i = n - 1;
		while (i > 0 && num[i - 1] >= num[i])
			i--;

		int j = i;
		if (i > 0) {
			while (j < n && num[j] > num[i - 1])
				j++;
			// swap
			int tmp = num[i - 1];
			num[i - 1] = num[j - 1];
			num[j - 1] = tmp;
		}

		// reverse
		j = n - 1;
		while (i < j) {
			int tmp = num[i];
			num[i++] = num[j];
			num[j--] = tmp;
		}
	}

}
