import java.util.*;

public class SummaryOfRanges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SummaryOfRanges cor = new SummaryOfRanges();
		List<String> a = cor.summaryRanges(new int[] { 0, 1 });
		return;
	}

	public List<String> summaryRanges(int[] nums) {

		List<String> ret = new LinkedList<>();
		if (nums.length == 0)
			return ret;
		if (nums.length == 1) {
			ret.add(nums[0] + "");
			return ret;
		}

		int state = 1, prev = nums[0];
		StringBuilder currStr = new StringBuilder();
		currStr.append(prev);

		for (int i = 1; i < nums.length; i++) {

			int curr = nums[i];
			if (curr == prev)
				continue; // repeating numbers
			if (state == 1 && curr > prev + 1) {
				ret.add(currStr.toString());
				prev = curr;
				currStr = new StringBuilder();
				currStr.append(prev);
			}
			if (state == 1 && curr == prev + 1) {
				state = 2;
				currStr.append("->");
			}

			if (state == 2 && curr == prev + 1) {
				prev = curr;
			}

			if (state == 2 && curr > prev + 1) {
				currStr.append(prev);
				ret.add(currStr.toString());
				prev = curr;
				currStr = new StringBuilder();
				currStr.append(prev);
				state = 1;
			}
		}
		return ret;
	}
}
