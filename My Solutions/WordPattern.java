import java.util.*;

public class WordPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
	}

	public boolean wordPattern(String pattern, String str) {
		int nP = pattern.length();
		String[] ss = str.split(" ");
		int nS = ss.length;
		if (nP != nS)
			return false;
		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < nP; i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(ss[i]))
					return false;
			} else {
				map.put(c, ss[i]);
			}
		}
		return true;
	}

}
