import java.util.*;

public class WorkBreakII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WorkBreakII wb2 = new WorkBreakII();

		Set<String> test = new HashSet<>();
		test.add("a");

		List<String> res = wb2.wordBreak("a", test);

		return;
	}

	Map<String, List<String>> rMap; // result map
	Set<String> imSet; // impossible set
	Set<String> dict;

	public List<String> wordBreak(String s, Set<String> dict) {

		// if (s.length() > 100) return null;

		rMap = new HashMap<>(); // result map
		imSet = new HashSet<>(); // impossible set
		this.dict = dict;

		return helper(s);
	}

	private List<String> helper(String s) {

		if (rMap.containsKey(s))
			return rMap.get(s);
		if (imSet.contains(s))
			return null;

		List<String> ret = new LinkedList<>();

		for (int i = 1; i <= s.length(); i++) {
			String front = s.substring(0, i);
			String end = s.substring(i);
			if (dict.contains(front)) {
				if (i == s.length()) {
					ret.add(front);
				} else {
					List<String> remainSet = wordBreak(end, dict);
					if (remainSet == null) {
						imSet.add(end);
						return null;
					} else {
						for (String str : remainSet) {
							ret.add(front + " " + str);
						}
						rMap.put(end, remainSet);
					}
				}
			}
		}
		return ret;
	}
}
