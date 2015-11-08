import java.util.*;

public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		generateParenthesis(2);
		return;

	}

	public static List<String> generateParenthesis(int n) {

		List<String> result = new LinkedList<>();
		StringBuilder s = new StringBuilder();
		sol1(result, s, n, 0);
		return result;

	}

	private static void sol1(List<String> l, StringBuilder s, int nL, int nR) {

		if (nL == 0 && nR == 0) {
			l.add(s.toString());
			return;
		}
		if (nR > 0) {
			s = s.append(")");
			sol1(l, s, nL, nR - 1);
			s.deleteCharAt(s.length() - 1);
		}
		if (nL > 0) {
			s = s.append("(");
			sol1(l, s, nL - 1, nR + 1);
			s.deleteCharAt(s.length() - 1);
			
		}
	}

}
