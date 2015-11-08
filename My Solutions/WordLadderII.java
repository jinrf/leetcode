import java.util.*;

public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLadderII wl2 = new WordLadderII();
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("b");
		dict.add("c");

		List result = wl2.findLadders("a", "c", dict);
		return;
	}

	int minStep;
	List<String> current;
	List<List<String>> ret;
	Set<String> visited;
	String target;

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		ret = new LinkedList<>();
		if (start.equals(end))
			return ret;

		minStep = -1;
		current = new LinkedList<>();
		visited = new HashSet<>();
		target = end;

		current.add(start);
		visited.add(start);
		findLadder(1);
		return ret;
	}

	private void findLadder(int n) {
		if (minStep != -1 && n > minStep)
			return;
		String tail = current.get(current.size() - 1); // get the last string

		for (int i = 0; i < current.size(); i++) {
			StringBuilder sb = new StringBuilder(tail);
			for (char c = 'a'; c <= 'z'; c++) {
				sb.setCharAt(i, c);
				String neighbor = sb.toString();
				if (neighbor.equals(tail))
					continue;
				if (neighbor.equals(target)) {
					minStep = n;
					ret.add(new ArrayList<String>(current));
					return;
				}
				visited.add(neighbor);
				current.add(neighbor);
				findLadder(n + 1);
				current.remove(neighbor);
			}
		}
	}

}
