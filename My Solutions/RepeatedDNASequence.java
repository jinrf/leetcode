import java.util.*;

public class RepeatedDNASequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findRepeatedDnaSequences(String s) {

		 return sol1(s);
		//return sol2(s);

	}

	private List<String> sol1(String s) {
		HashMap<Integer, Integer> m = new HashMap<>();
		List<String> result = new LinkedList<>();

		int len = s.length();
		if (len <= 10) {
			return result;
		}

		int key = 0;
		for (int i = 0; i < 9; i++) {
			key = key << 2 | s.charAt(i) >> 1 & 3;
		}

		for (int i = 9; i < len; i++) {
			Integer count = m
					.get(key = (key << 2 & 0xFFFFF | s.charAt(i) >> 1 & 3));
			if (count == null) {
				m.put(key, 1);
			} else if (count == 1) {
				result.add(s.substring(i - 9, i + 1));
				m.put(key, 2);
			}
		}

		return result;
	}

}
