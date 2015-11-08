public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		ListNode ret = rl.rotateRight(a, 5);
		return;

	}

	public ListNode rotateRight(ListNode head, int n) {

		if (head == null || head.next == null)
			return head;
		ListNode fast = head, slow = head;

		int count = 1;
		while (fast.next != null) {
			count++;
			fast = fast.next;
		}
		fast = head;

		for (int i = 0; i < n % count; i++) {
			if (fast.next != null) {
				fast = fast.next;
			} else {
				fast = head;
			}
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		fast.next = head;
		ListNode ret = slow.next;
		slow.next = null;
		return ret;
	}

}
