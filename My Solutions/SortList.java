public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortList sl = new SortList();

		ListNode a = new ListNode(2);
		a.next = new ListNode(1);

		ListNode result = sl.sortList(a);
		return;

	}

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode vHead = new ListNode(-1);
		vHead.next = head;
		ListNode slow = vHead, fast = vHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondHalf = sortList(slow.next);
		slow.next = null;
		return merge(sortList(head), secondHalf);

	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode vHead = new ListNode(-1);
		ListNode curr = vHead;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		if (l1 == null) {
			curr.next = l2;
		} else {
			curr.next = l1;
		}
		return vHead.next;
	}
}
