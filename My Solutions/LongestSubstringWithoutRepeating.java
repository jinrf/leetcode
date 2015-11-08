import java.util.*;

public class LongestSubstringWithoutRepeating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("aa"));
	}

	public static int lengthOfLongestSubstring(String s) {

		int len = s.length();
		int maxLen = 0, start = 0;

		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < len; i++) {
			Integer loc = m.get(s.charAt(i));
			if (loc != null) {
				if (loc >= start) {
					maxLen = Math.max(maxLen, (i - 1) - start + 1);
					start = loc + 1;
				}
			}
			maxLen = Math.max(maxLen, i - start + 1);
			m.put(s.charAt(i), i);
		}

		return maxLen;
	}

}
