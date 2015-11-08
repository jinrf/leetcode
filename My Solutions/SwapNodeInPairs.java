public class SwapNodeInPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		// a.next.next = new ListNode(3);
		swapPairs(a);

	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode oddHead = new ListNode(-1), evenHead = new ListNode(-1);
		ListNode odd = oddHead, even = evenHead;
		int count = 0;
		while (head != null) {
			if (count++ % 2 == 0) {
				odd.next = head;
				odd = odd.next;
			} else {
				even.next = head;
				even = even.next;
			}
			head = head.next;
		}

		odd.next = even.next = null;
		ListNode vHead = new ListNode(-1);
		ListNode curr = vHead;
		odd = oddHead.next;
		even = evenHead.next;
		for (int i = 0; i < count; i++) {
			if (i % 2 == 1) {
				curr.next = odd;
				odd = odd.next;
			} else {
				if (even == null) {
					curr.next = odd;
					break;
				}
				curr.next = even;
				even = even.next;
			}
			curr = curr.next;
		}
		return vHead.next;
	}

}
