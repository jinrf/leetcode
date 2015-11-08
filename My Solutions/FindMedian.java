import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> test = new PriorityQueue<>();
		test.add(5);
		test.add(6);
		test.add(1);
		test.add(3);
		test.add(2);

		while (!test.isEmpty()) {
			System.out.println(test.remove());
		}
	}

	public double findMedian(int[] nums) {

		PriorityQueue<Integer> left = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return b.compareTo(a); // descending order
					}
				});
		PriorityQueue<Integer> right = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return a.compareTo(b); // descending order
					}
				});
		left.add(Integer.MIN_VALUE);
		right.add(Integer.MAX_VALUE);

		for (int i = 0; i < nums.length; i++) {
			if (left.size() == right.size()) {
				if (nums[i] > right.peek()) {
					int rightTop = right.remove();
					left.add(rightTop);
					right.add(nums[i]);
				} else {
					left.add(nums[i]);
				}
			} else {
				left.add(nums[i]);
				int leftTop = left.remove();
				right.add(leftTop);
			}
		}

		if ((nums.length & 1) == 1)
			return left.peek();
		else
			return (left.peek() + right.peek()) / 2.0;
	}

	class MyComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
	}
}
