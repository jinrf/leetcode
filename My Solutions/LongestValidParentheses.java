import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		System.out.println(lvp.dpSol("()(())"));

	}

	private int dpSol(String s) {
		int len = s.length();
		if (len < 2)
			return 0;
		int[] dp = new int[len + 1]; // first is empty

		for (int i = 1; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				continue;
			} else {
				if (s.charAt(i - 1) == '(') {
					dp[i + 1] = dp[i - 1] + 2;
				} else {
					if (i - dp[i] - 1 >=0 && s.charAt(i - dp[i] - 1) == '(') {
						dp[i + 1] = dp[i - dp[i] - 1] +  i - (i - dp[i] - 1) + 1 ;
					} else {
						dp[i + 1] = 0;
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= len; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	private int stackSol(String s) {
		int lenS = s.length();
		Stack<Integer> stack = new Stack<>();
		int last = 0;
		int maxLen = 0;

		for (int i = 0; i < lenS; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i + 1; // not valid, reset starting position
				} else { // there is a matching '('
					stack.pop();
					if (stack.isEmpty()) {
						maxLen = Math.max(maxLen, i - last + 1);
					} else {
						maxLen = Math.max(maxLen, i - (stack.peek() + 1) + 1);
					}
				}
			}
		}

		return maxLen;
	}

}
