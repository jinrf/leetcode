import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		System.out.print(threeSumClosest(new int[] { 1, 1, -1, -1, 3 }, 1));

	}

	public static int threeSumClosest(int[] num, int target) {

		Arrays.sort(num);
		int len = num.length;
		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < len - 2; i++) {
			
			int j = i + 1, k = len - 1;
			while (j < k) {
				int diff = num[i] + num[j] + num[k] - target;
				if (Math.abs(diff) < Math.abs(minDiff))
					minDiff = diff;
				while (j < k && num[j + 1] == num[j])
					j++;
				while (j < k && num[k - 1] == num[k])
					k--;
				if (diff > 0)
					k--;
				else
					j++;
			}
		}

		return target + minDiff;
	}
}