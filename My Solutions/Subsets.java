import java.util.*;

public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		subsetsWithDup(new int[] {1,2,2});

	}

	public List<List<Integer>> subsets(int[] S) {

		int len = S.length;
		List<List<Integer>> ret = new LinkedList<>();
		long n = (long) Math.pow(2, len);
		for (long i = 0; i < n; i++) {
			List<Integer> tmp = new LinkedList<>();
			for (int j = 0; j < len; j++) {
				if ((i >> j & 1L) == 1) {
					tmp.add(S[j]);
				}
			}
			ret.add(tmp);
		}
		return ret;
	}

	public static List<List<Integer>> subsetsWithDup(int[] num) {

		Arrays.sort(num);
		List<List<Integer>> ret = new LinkedList<>();
		List<Integer> empty = new LinkedList<>();
		ret.add(empty);
		int len = num.length, l = 0;
		if (len < 1)
			return ret;
		for (int i = 0; i < len; i++) {
			int n = ret.size();
			if (i == 0 || num[i] != num[i - 1])
				l = n; // size of last set without dups
			for (int j = n - l; j < n; j++) {
				List<Integer> newList = new LinkedList(ret.get(j));
				newList.add(num[i]);
				ret.add(newList);
			}
		}
		return ret;

	}
}
