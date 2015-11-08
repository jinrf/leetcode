import java.util.*;

public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		List l = cs.combinationSum(new int[] { 1, 2 }, 3);
		return;
	}

	List<List<Integer>> ret;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ret = new LinkedList<>();
		int len = candidates.length;
		if (len == 0)
			return ret;
		List<Integer> list = new LinkedList<>();
		Arrays.sort(candidates);
		search(candidates, 0, target, list);
		return ret;
	}

	private void search(int[] nums, int start, int target, List<Integer> list) {
		int len = nums.length;
		for (int i = start; i < len; i++) {
			if (nums[i] < 0)
				continue;
			if (target == nums[i]) {
				list.add(nums[i]);
				ret.add(new LinkedList<Integer>(list));
				list.remove(list.size() - 1);
				return;
			} else if (target < nums[i]) {
				continue;
			} else {
				list.add(nums[i]);
				search(nums, i, target - nums[i], list);
				list.remove(list.size() - 1);
			}
		}
	}

}
