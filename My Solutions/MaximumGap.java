import java.util.*;

public class MaximumGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumGap mg = new MaximumGap();
		System.out.print(mg.maximumGap(new int[]{1, 10000000}));

	}

	public int maximumGap(int[] num) {
		int len = num.length;
		if (len < 2)
			return 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int n : num) {
			if (n > max)
				max = n;
			if (n < min)
				min = n;
		}

		int gapLen = (max - min) / len + 1;
		Map<Integer, MyData> m = new HashMap<>();

		for (int n : num) {
			int i = n / gapLen;
			if (m.containsKey(i)) {
				MyData tmp = m.get(i);
				tmp.update(n);
				m.put(i, tmp);
			} else {
				MyData tmp = new MyData();
				tmp.update(n);
				m.put(i, tmp);
			}
		}

		int maxGap = Integer.MIN_VALUE;
		int prev = min;
		for (int i = 0; i <= len; i++) {
			if (m.containsKey(i)) {
				maxGap = Math.max(maxGap, m.get(i).min - prev);
				prev = m.get(i).max;
			}
		}
		return maxGap;
	}

	class MyData {
		int max, min;

		public MyData() {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
		}

		public void update(int n) {
			this.max = Math.max(this.max, n);
			this.min = Math.min(this.min, n);
		}
	}

}
