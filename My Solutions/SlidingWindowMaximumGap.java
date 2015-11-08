import java.util.*;

public class SlidingWindowMaximumGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDiff(int[] A) {
		int max = Integer.MIN_VALUE;

		Deque<Integer> maxQ = new ArrayDeque<>();
		Deque<Integer> minQ = new ArrayDeque<>();

		for (int i = 0; i < A.length; i++) {
			while (!maxQ.isEmpty() && A[i] > A[maxQ.peekLast()]) {
				maxQ.removeLast();
			}
			maxQ.push(i);

			while (!minQ.isEmpty() && A[i] < A[minQ.peekLast()]) {
				minQ.removeLast();
			}
			minQ.push(i);
			max = Math.max(maxQ.peekFirst() - minQ.peekFirst(), max);
		}
		return max;

	}
}
