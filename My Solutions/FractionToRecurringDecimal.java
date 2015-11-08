import java.util.*;

public class FractionToRecurringDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(-1, -2147483648));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";

		String result = "";
		if (numerator > 0 ^ denominator > 0) {
			result = "-";

		}

		long num = Math.abs(numerator);
		long den = Math.abs(denominator);

		result += num / den; // before fraction
		num %= den;

		HashMap<Long, Integer> m = new HashMap<>(); // numerator, location
		StringBuilder s = new StringBuilder();
		int loc = 0;
		while (num != 0) {
			num *= 10;
			if (!m.containsKey(num)) {
				s.append(num / den);
				m.put(num, loc);
				num %= den;
				loc++;
			} else {
				int start = m.get(num);
				return result + "." + s.substring(0, start) + "("
						+ s.substring(start, loc) + ")";
			}
		}
		return loc == 0 ? result : result + "." + s.toString();
	}
}
