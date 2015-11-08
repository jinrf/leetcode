import java.util.*;

public class InsertionSortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int t = 0;
		System.out.println(t);

		InsertionSortList isl = new InsertionSortList();
		ListNode a = new ListNode(3);
		a.next = new ListNode(2);
		a.next.next = new ListNode(1);
		ListNode ret = isl.insertionSortList(a);
		return;

	}

	public ListNode insertionSortList(ListNode head) {

		ListNode vHead = new ListNode(-1);
		// vHead.next = head;

		ListNode curr = head;

		// idea: for each current node, scan the first element that is larger,
		// and insert curr before that node.
		while (curr != null) {

			ListNode pre = vHead;
			while (pre.next != null && pre.next.val <= curr.val) {
				pre = pre.next;
			}
			ListNode n = curr.next;
			curr.next = pre.next;
			pre.next = curr;
			curr = n;
		}

		return vHead.next;

	}

	public String largestNumber(int[] num) {
		int len = num.length;
		List<String> nums = new ArrayList<>();

		for (int i : num)
			nums.add(Integer.toString(i));
		Collections.sort(nums, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String n : nums) {
			sb.append(n);
		}

		if (sb.charAt(0) == '0' && sb.length() > 1)
			return "0";

		return sb.toString();
	}

}
