import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WiggleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WiggleSort ws = new WiggleSort();
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] result = ws.wiggleSort(nums);

		Vector v = new Vector();
		List l = new LinkedList();
		Set s = new HashSet();
		ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();
		clq.offer(1);
		Hashtable<String, Integer> ht = new Hashtable<>();
		
		HashMap m = new HashMap();

		return;
	}

	public int[] wiggleSort(int[] nums) {

		boolean shouldBeGreater = false;

		for (int i = 0; i < nums.length - 1; i++) {
			if (shouldBeGreater && nums[i] < nums[i + 1]) {
				int tmp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = tmp;
			}

			if (!shouldBeGreater && nums[i] > nums[i + 1]) {
				int tmp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = tmp;
			}
			shouldBeGreater = !shouldBeGreater;
		}
		return nums;
	}
}
