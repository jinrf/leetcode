import java.util.*;

public class LetterCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static String[] map = new String[] { "0", "1", "abc", "def", "ghi",
			"jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {

		List<String> res = new LinkedList<>();
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			List<String> tmpres = new LinkedList<String>();
			for (String str : res) {
				String letters = map[(int) (digits.charAt(i) - '0')];
				for (int j = 0; i < letters.length(); i++) {
					tmpres.add(str + letters.charAt(i));
				}
			}
			res = tmpres;
		}
		return res;
	}
}
