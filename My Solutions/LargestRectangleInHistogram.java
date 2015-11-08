import java.util.*;

public class LargestRectangleInHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		largestRectangleArea(new int[] { 6, 2, 5, 4, 5, 1, 6 });
	}

	public static int largestRectangleArea(int[] height) {
		int len = height.length, i = 0, max = 0;
		Stack<Integer> s = new Stack<>();

		while (i < len) {

			if (s.isEmpty() || height[s.peek()] < height[i])
				s.push(i++);
			else {
				int h = height[s.pop()];
				int area = h * (s.isEmpty() ? i : i - s.peek() - 1);
				max = Math.max(max, area);
			}
		}

		while (!s.isEmpty()) {
			max = Math.max(max,
					height[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1));
		}

		return max;
	}

	public static int largestRectangleArea1(int[] height) {
		height = Arrays.copyOf(height, height.length + 1);

		int maxRect = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; ++i) {
			while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
				int rect = height[stack.pop()]
						* (stack.isEmpty() ? i : (i - stack.peek() - 1));
				maxRect = Math.max(maxRect, rect);
			}
			stack.push(i);
		}

		return maxRect;
	}

}
