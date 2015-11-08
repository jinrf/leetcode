import java.util.*;

public class PermutationsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationsII p2 = new PermutationsII();
		p2.permuteUnique(new int[] { -1, -1, 3, -1 });
	}

	private int[] num;
	private boolean[] flag;
	private int n;
	private List<List<Integer>> ret;
	private LinkedList<Integer> curr;

	public List<List<Integer>> permuteUnique(int[] num) {
		int len = num.length;
		Arrays.sort(num);
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
			ret.add(new LinkedList<>(curr));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!flag[i]) {
				if (i > 0 && num[i] == num[i - 1] && flag[i - 1] == true)
					continue;
				curr.add(num[i]);
				flag[i] = true;
				permute(k + 1);
				flag[i] = false;
				curr.removeLast();
			}
		}
	}

}
