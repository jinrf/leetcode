import java.util.*;

public class RomanToInt {
	private static Map<Character, Integer> rMap;
	static {
		rMap = new HashMap<Character, Integer>();
		rMap.put('I', 1);
		rMap.put('V', 5);
		rMap.put('X', 10);
		rMap.put('L', 50);
		rMap.put('C', 100);
		rMap.put('D', 500);
		rMap.put('M', 1000);
	};

	public int romanToInt(String s) {
		int result = 0;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			int v = rMap.get(s.charAt(i));
			if (i < len - 1 && v < rMap.get(s.charAt(i + 1))) {
				v = -v;
			}
			result += v;
		}
		return result;
	}
}