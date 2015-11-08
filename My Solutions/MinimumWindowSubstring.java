import java.util.*;

public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.findSubstring("abababab", new String[] { "a",
				"b", "a" }));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		// return brutalForce(s, words);
		return slidingWindow(s, words);
	}

	private List<Integer> slidingWindow(String s, String[] words) {
		List<Integer> result = new LinkedList<>();
		if (words.length == 0 || words[0].length() == 0
				|| s.length() < words[0].length())
			return result;

		HashMap<String, Integer> dict = new HashMap<>();
		for (int i = 0; i < words.length; i++)
			dict.put(words[i],
					dict.containsKey(words[i]) ? dict.get(words[i]) + 1 : 1);

		int winSize = words.length * words[0].length();
		int wordLen = words[0].length();

		for (int offset = 0; offset < wordLen; offset++) {
			int i = offset, j = i;
			HashMap<String, Integer> curr = new HashMap<>(dict);
			while (j <= s.length() - wordLen) {
				String str = s.substring(j, j + wordLen);
				if (curr.containsKey(str)) {
					if (curr.get(str) > 0) { // match
						curr.put(str, curr.get(str) - 1);
					} else { // more than needed, try shift to the right
						if (s.substring(i, i + wordLen).equals(str)) {
							i += wordLen; // succeed.
						} else { // failed. move i to the right.
							while (!s.substring(i, i + wordLen).equals(str)) {
								curr.put(
										s.substring(i, i + wordLen),
										curr.get(s.substring(i, i + wordLen)) + 1);
								i += wordLen;
							}
							i += wordLen; // start from next
						}
					}
				} else {
					i = j + wordLen;
					curr = new HashMap<>(dict);
				}
				j += wordLen;
				if (j - i == winSize) {
					result.add(i);
				}
			}

		}
		return result;
	}

	private List<Integer> improvedBrutalForce(String s, String[] words) {
		List<Integer> result = new LinkedList<>();
		if (words.length == 0 || words[0].length() == 0
				|| s.length() < words[0].length())
			return result;

		Hashtable<String, Integer> dict = new Hashtable<>();
		for (int i = 0; i < words.length; i++)
			dict.put(words[i],
					dict.containsKey(words[i]) ? dict.get(words[i]) + 1 : 1);

		int winSize = words.length * words[0].length();
		int wordLen = words[0].length();

		for (int offset = 0; offset < wordLen; offset++) {
			int i = offset;

			while (i <= s.length() - winSize) {
				Hashtable<String, Integer> curr = new Hashtable<>(dict);
				int j = i;
				while (j < s.length() && j - i < winSize) {
					String str = s.substring(j, j + wordLen);
					if (!curr.containsKey(str)) {
						break;
					} else {
						int count = curr.get(str);
						if (count > 1) {
							curr.put(str, count - 1);
						} else {
							curr.remove(str);
						}
					}
					j += wordLen;
				}
				if (curr.size() == 0) { // found!!!
					result.add(i);
				}
				i += wordLen;
			}
		}
		return result;
	}

	private List<Integer> brutalForce(String s, String[] words) {
		List<Integer> ret = new LinkedList<>();

		int sLen = s.length();
		int wLen = words.length;

		if (wLen == 0)
			return ret;
		int wordLen = words[0].length();

		Map<String, Integer> wordSet = new HashMap<>();
		for (String w : words)
			wordSet.put(w, wordSet.containsKey(w) ? wordSet.get(w) + 1 : 1);

		for (int i = 0; i + wordLen * wLen <= sLen; i++) {
			Map<String, Integer> currSet = new HashMap<>(wordSet);
			for (int j = i; j - i < wordLen * wLen; j += wordLen) {
				String currStr = s.substring(j, j + wordLen);
				if (!currSet.containsKey(currStr))
					break;
				int count = currSet.get(currStr);
				if (count > 1)
					currSet.put(currStr, count - 1);
				else
					currSet.remove(currStr);
			}
			if (currSet.isEmpty())
				ret.add(i);
		}

		return ret;
	}
}
