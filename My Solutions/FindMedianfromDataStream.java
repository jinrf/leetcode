import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedianfromDataStream f = new FindMedianfromDataStream();
		f.addNum(2);
		System.out.println(f.findMedian());
		f.addNum(3);
		System.out.println(f.findMedian());

	}

	private PriorityQueue<Integer> left, right;

	// Adds a number into the data structure.
	public void addNum(int num) {
		right.add(num);
		left.add(right.poll());

		if (right.size() < left.size()) {
			right.add(left.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (left.size() > right.size()) {
			return left.peek();
		} else if (left.size() < right.size())
			return right.peek();
		else {
			return (left.peek() + right.peek()) / 2.0;
		}
	}

	FindMedianfromDataStream() {
		left = new PriorityQueue<>(1, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		right = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
	}

}
