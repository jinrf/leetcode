import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		Combinations cb = new Combinations();
		cb.combine(4, 2);
	}

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> lstlst = new ArrayList<List<Integer>>();

		if (k == 0) {
			return null;
		} else if (n == k) {
			List<Integer> lst = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				lst.add(i);
				lstlst.add(lst);
			}
		} else {
			List<List<Integer>> l1 = combine(n - 1, k); // not include n;
			List<List<Integer>> l2 = combine(n - 1, k - 1); // include n;
			lstlst.addAll(l1);
			if (l2 != null) {
				for (List<Integer> l : l2) {
					l.add(n);
					lstlst.add(l);
				}
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(n);
				lstlst.add(l);
			}
		}
		return lstlst;

	}
}
