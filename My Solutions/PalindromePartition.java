import java.util.*;

public class PalindromePartition {
	public static void main(String[] args) {

		PalindromePartition pp = new PalindromePartition();
		List<List<String>> result = pp.partition("a");
		return;
	}

	private List<List<String>> result;
	private List<String> curr;

	public List<List<String>> partition(String s) {

		result = new LinkedList<>();
		curr = new ArrayList<>();

		backTracking(s);
		return result;
	}

	private void backTracking(String s) {
		int len = s.length();
		if (len == 0) {
			result.add(new LinkedList<>(curr));
			return;
		}

		for (int i = 1; i <= len; i++) {
			String left = s.substring(0, i);
			if (!isPalindrome(left))
				continue;
			curr.add(left);
			String right = s.substring(i);
			backTracking(right);
			curr.remove(curr.size() - 1);
		}
	}

	private boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j)
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		return true;
	}

	public List<List<String>> partitionOld(String s) {

		List<List<String>> result = new LinkedList<>();
		int len = s.length();

		for (int i = 1; i <= len; i++) {
			String firstHalf = s.substring(0, i);
			if (isPalindrome(firstHalf)) {
				List<List<String>> partitions = partition(s.substring(i));
				if (partitions.isEmpty()) {
					List<String> l = new LinkedList<>();
					l.add(firstHalf);
					partitions.add(l);

				} else {
					for (List<String> l : partitions) {
						l.add(firstHalf);
					}
				}
				result.addAll(partitions);
			}
		}
		return result;
	}
}
