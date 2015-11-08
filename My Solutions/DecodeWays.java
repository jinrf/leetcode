public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("110"));

	}

	private int[] t;

	public int numDecodings(String s) {
		int len = s.length();
		t = new int[len + 1];
		t[0] = 1;
		int n = helper(s, 0);
		return n == -1 ? 0 : n;
	}

	private int helper(String s, int i) {
		int len = s.length() - i;
		if (len == 0)
			return 0;
		if (s.charAt(i) == '0')
			return -1; // error
		if (len == 1)
			return 1;

		if (s.charAt(i) - '0' <= 2 && s.charAt(i + 1) - '0' <= 6
				&& s.charAt(i + 1) - '0' > 0) {
			if (t[i + 1] == 0)
				t[i + 1] = helper(s, i + 1);
			if (i + 2 < len && t[i + 2] == 0)
				t[i + 2] = helper(s, i + 2);
			if (t[i + 1] == -1 && t[i + 2] == -1)
				return -1;
			return t[i + 1] + Math.max(1, t[i + 2]);
		} else if (s.charAt(i) - '0' <= 2 && s.charAt(i + 1) - '0' == 0) {
			if (i + 2 < len && t[i + 2] == 0)
				t[i + 2] = helper(s, i + 2);
			if (t[i + 2] == -1)
				return -1;
			return Math.max(1, t[i + 2]);
		} else if (s.charAt(i) - '0' <= 1) {
			if (t[i + 1] == 0)
				t[i + 1] = helper(s, i + 1);
			
			return t[i + 1] == -1? -1: 1 + t[i + 1];
		} else {
			if (t[i + 1] == 0)
				t[i + 1] = helper(s, i + 1);

			return t[i + 1] == -1 ? -1 : t[i + 1];
		}
	}
}
