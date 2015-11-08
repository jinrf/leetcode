public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(30));
	}

	public String countAndSay(int n) {

		if (n == 0)
			return "";
		String s = "1";
		while (n > 1) {
			int i = 0;
			StringBuilder sb = new StringBuilder();
			while (i < s.length()) {
				char c = s.charAt(i++);
				int count = 1;
				while (i < s.length() && s.charAt(i) == c) {
					i++;
					count++;
				}
				sb.append(count);
				sb.append(c);
			}
			s = sb.toString();
			n--;
		}
		return s;
	}

	public String countAndSayOld(int n) {

		if (n == 1)
			return "1";

		String s = countAndSay(n - 1);
		StringBuilder sb = new StringBuilder();

		int i = 0, len = s.length();
		while (i++ < len) {
			int count = 1;
			while (i < len && s.charAt(i) == s.charAt(i - 1)) {
				count++;
				i++;
			}
			sb.append(count + "" + s.charAt(i - 1));
		}
		return sb.toString();

	}
}
