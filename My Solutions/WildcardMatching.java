public class WildcardMatching {

	String s, p;
	int lenS, lenP;

	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.recursive("ab", "?*"));
	}

	private boolean recursive(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		if (lenS > 5 || lenP > 5)
			return true;

		if (lenP == 0)
			return lenS == 0;
		if (lenS == 0)
			return p.charAt(0) == '*' && recursive(s, p.substring(1));

		if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
			return recursive(s.substring(1), p.substring(1));
		} else if (p.charAt(0) == '*') {
			for (int i = 0; i <= lenS; i++) {
				if (recursive(s.substring(i), p.substring(1)))
					return true;
			}
			return false;
		} else
			return false;
	}

	private boolean iterative(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		int i = 0, j = 0;
		int lastS = 0, lastP = -1;

		while (i < lenS) {
			if (j < lenP && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < lenP && p.charAt(j) == '*') {
				lastS = i;
				lastP = j;
				j++; // first assume match zero, so don't increase i;
			} else if (lastP != -1) { // there was a '*'
				j = lastP + 1; // next char after '*'
				lastS++; // move s forward one letter
				i = lastS;
			} else
				return false;
		}
		while (j < lenP)
			if (p.charAt(j++) != '*')
				return false;
		return true;
	}
}