public class ReverseWordsInAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverseWords("   a   b "));

	}

	public static String reverseWords(String s) {

		s = s.trim();
		String[] words = s.split(" ");
		StringBuilder r = new StringBuilder();
		for (String w : words) {
			if (w.equals(""))
				continue;
			r.insert(0, w.trim() + " ");
		}

		return r.toString().trim();
	}

}
