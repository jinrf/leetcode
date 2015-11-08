import java.util.*;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Permutations p = new Permutations();
		p.permute(new int[] { -1, -1, 3, -1 });
	}

	private int[] num;
	private boolean[] flag;
	private int n;
	private List<List<Integer>> ret;
	private LinkedList<Integer> curr;

	public List<List<Integer>> permute(int[] num) {
		int len = num.length;
		this.num = num;
		this.flag = new boolean[len];
		this.n = len;
		this.ret = new LinkedList<>();
		this.curr = new LinkedList<>();

		permute(0);
		return ret;
	}

	private void permute(int k) {
		if (k == n) {
			ret.add(curr);
			curr = new LinkedList<>();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (i > 0 && num[i] == num[i - 1]) continue;
			if (!flag[i]) {
				curr.add(num[i]);
				flag[i] = true;
				permute(k + 1);
				flag[i] = false;
				curr.removeLast();
			}
		}
	}
}
