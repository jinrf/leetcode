import java.util.*;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "ab";
		String c = "cd";
		Set<String> dict = new HashSet<>();
		dict.add("ad");
		dict.add("bd");
		dict.add("cd");

		System.out.println(ladderLength(a, c, dict));

	}

	public static int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end))
			return 1;
		int dictSize = dict.size();

		Set<String> visited = new HashSet<>();
		Deque<String> q = new ArrayDeque<>();
		q.add(start);
		q.add(""); // as a separator
		visited.add(start);

		int nStep = 2;

		while (!q.isEmpty()) {
			String curr = q.remove();
			for (int i = 0; i < curr.length(); i++) {
				StringBuilder s = new StringBuilder(curr);
				for (char c = 'a'; c <= 'z'; c++) {
					s.setCharAt(i, c);
					String tmp = new String(s);
					if (tmp.equals(curr))
						continue;
					if (dict.contains(tmp) && !visited.contains(tmp)) {
						if (tmp.equals(end))
							return nStep;
						else {
							visited.add(tmp);
							q.add(tmp);
						}
					}
				}
			}

			if (!q.isEmpty() && q.peek().length() == 0) {
				q.remove();
				nStep++;
				q.add(""); // marker element
			}
		}
		return 0;
	}

	private static boolean isNeighbor(String a, String b) {
		int len = a.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
		}
		return count == 1 ? true : false;
	}

}
