import java.util.*;

public class ExpressionAddOperators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExpressionAddOperators eao = new ExpressionAddOperators();
		List<String> ret = eao.addOperators("000", 0);
		return;
	}

	private int target;
	private String num;
	private List<String> res;

	public List<String> addOperators(String num, int target) {
		this.target = target;
		this.num = num;
		res = new LinkedList<>();

		for (int i = 1; i <= num.length(); i++) {
			String curVal = num.substring(0, i);
			Long lVal = Long.parseLong(curVal);
			if (i > 1 && lVal < 10)
				continue;
			helper("" + lVal, i, lVal, lVal);
		}
		return res;
	}

	private void helper(String curExp, int pos, long curEval, long preVal) {
		if (pos == num.length() && curEval == target) {
			res.add(curExp);
			return;
		}
		for (int i = pos + 1; i <= num.length(); i++) {
			if (i > pos + 1 && num.charAt(pos) == '0')
				return;
			int curVal = Integer.parseInt(num.substring(pos, i));
			helper(curExp + "+" + curVal, i, curEval + curVal, curVal);
			helper(curExp + "-" + curVal, i, curEval - curVal, -curVal);
			helper(curExp + "*" + curVal, i,
					curEval - preVal + preVal * curVal, preVal * curVal);
		}
	}

}
