import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		int[] test = new int[] { -1, 0, 1, 0 };

		System.out.println(threeSum(test));
	}

	public static List<List<Integer>> threeSum(int[] num) {

		List<List<Integer>> result = new LinkedList<>();
		int len = num.length;

		if (len < 3)
			return result;
		Arrays.sort(num);

		for (int i = 0; i < len - 2; i++) {
			int j = i + 1, k = len - 1, target = -num[i];
			while (j < k) {
				if (num[j] + num[k] == target) {
					result.add(Arrays.asList(num[i], num[j], num[k])); // sorted
					while (num[j] == num[j + 1])
						j++;
					while (num[k] == num[k - 1])
						k--;
					j++;
					k--;
				} else if (num[j] + num[k] < target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return result;

	}
}