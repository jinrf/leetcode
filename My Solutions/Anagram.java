import java.util.*;

public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> anagrams(String[] strs) {
		List<String> l = new ArrayList<>();
		int len = strs.length;
		if (len < 2)
			return l;

		Map<String, List<Integer>> m = new HashMap<>();
		Set<String> s = new HashSet<>();

		for (int i = 0; i < len; i++) {
			String tmp = sort(strs[i]);
			List<Integer> list = m.get(tmp);
			if (list == null) {
				list = new ArrayList<Integer>();
				list.add(i);
				m.put(tmp, list);
			} else {
				list.add(i);
				s.add(tmp);
			}
		}
		for (String str : s) {
			for (int i : m.get(str)) {
				l.add(strs[i]);
			}
		}
		return l;
	}

	private String sort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

}
