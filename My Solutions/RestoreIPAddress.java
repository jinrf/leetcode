import java.util.*;

public class RestoreIPAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RestoreIPAddress ria = new RestoreIPAddress();
		ria.restoreIpAddresses("25525511135");
		return;

	}

	private List<String> ret;
	private LinkedList<Integer> ip;

	public List<String> restoreIpAddresses(String s) {
		ret = new LinkedList<>();
		ip = new LinkedList<>();
		int len = s.length();
		if (len < 4 || len > 12)
			return ret;

		DFS(s, 0);
		return ret;
	}

	private void DFS(String s, int n) {
		if (n == 4) {
			if (s.length() == 0) {
				StringBuilder sb = new StringBuilder();
				for (int i : ip) {
					sb.append(i + "");
				}
				ret.add(sb.toString().substring(0, sb.length()));
			}
		}

		for (int i = 1; i <= 3 && i <= s.length(); i++) {
			String tmp = s.substring(0, i);
			int subIP = Integer.parseInt(tmp);
			if (subIP <= 255) {
				ip.add(subIP);
				DFS(s.substring(i), n + 1);
				ip.removeLast();
			}
		}
	}

}
