public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.println(rem.isMatch("a", ".*..a*"));
	}

	public boolean isMatch(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		if (lenP == 0)
			return lenS == 0;
		if (lenP == 1)
			return lenS == 1 && isMatchFirst(s, p);
		if (lenS == 0 && p.charAt(1) != '*')
			return false;
		
		if (p.charAt(1) != '*') {
			if (lenS < 2) {
				return isMatchFirst(s, p) && isMatch("", p.substring(1));
			} else {
				return isMatchFirst(s, p)
						&& isMatch(s.substring(1), p.substring(1));
			}
		}

		int i = 0;
		while (i < lenS && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
			if (lenP > 2 && isMatch(s.substring(i), p.substring(2)))
				return true;
			i++;
		}

		return isMatch(s.substring(i), p.substring(2));
	}

	private boolean isMatchFirst(String s, String p) {
		return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
	}
}
