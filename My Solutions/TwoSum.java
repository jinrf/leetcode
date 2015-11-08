import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			m.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (m.get(target - numbers[i]) != null
					&& m.get(target - numbers[i]) < i) {
				return new int[] { i, m.get(target - numbers[i]) };
			}
		}
		
		return null;

	}
}
