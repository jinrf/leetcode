import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ContainsDuplicateIII cd3 = new ContainsDuplicateIII();
		System.out.println(cd3.containsNearbyAlmostDuplicate(new int[] { -1,
				2147483647 }, 1, 2147483647));

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		Map<Long, Long> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			long b = ((long) nums[i] - Integer.MIN_VALUE) / ((long) t + 1);
			if (map.get(b) != null || map.get(b - 1) != null
					&& nums[i] - map.get(b - 1) <= t || map.get(b + 1) != null
					&& map.get(b + 1) - nums[i] <= t)
				return true;
			else {
				map.put(b, (long)nums[i]);
			}

			if (map.keySet().size() > k) {
				b = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(b);
			}
		}

		return false;
	}

}
