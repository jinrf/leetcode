public class ReverseNodeInKGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		reverseKGroup(a, 3);
		return;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k < 2)
			return head;
		ListNode vHead = new ListNode(-1);
		vHead.next = head;
		ListNode preHead = vHead, tail = vHead;

		while (true) {

			for (int i = 0; i < k; i++) {
				if (tail.next == null)
					return vHead.next;
				tail = tail.next;
			}
			ListNode nn = tail.next;
			ListNode pre = nn, curr = head;

			while (curr != nn) {
				ListNode tmp = curr.next;
				curr.next = pre;
				pre = curr;
				curr = tmp;
			}

			preHead.next = tail;
			tail = head;
			head = tail.next;

		}
	}

}
