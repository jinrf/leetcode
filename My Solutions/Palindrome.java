public class Palindrome {
	public boolean isPalindrome(String s) {
		int len = s.length();
		if (len == 0)
			return true;

		int begin = 0, end = len - 1;

		while (begin <= end) {
			while (!isAlphaNumeric(s.charAt(begin)))
				begin++;
			while (!isAlphaNumeric(s.charAt(end)))
				end--;

			if (Character.toLowerCase(s.charAt(begin)) == Character
					.toLowerCase(s.charAt(end))) {
				begin++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isAlphaNumeric(char c) {
		if (Character.isLetterOrDigit(c))
			return true;
		return false;
	}
}
