import java.util.*;

public class ReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();

		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		rl.reorderList(a);
		return;
	}

	public void reorderList(ListNode head) {

		noStack(head);
		return;
	}

	private void noStack(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode vHead = new ListNode(0);
		vHead.next = head;
		ListNode slow = vHead, fast = vHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode rHead = slow.next;
		slow.next = null;

		ListNode pre = null;
		while (rHead!= null) {
			ListNode tmp = rHead.next;
			rHead.next = pre;
			pre = rHead;
			rHead = tmp;
		}
		
		rHead = pre;

		while (head != null && rHead != null) {
			ListNode tmp = rHead.next;
			rHead.next = head.next;
			head.next = rHead;
			head = rHead.next;
			rHead = tmp;
		}

		return;
	}

	private void useStack(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode slow = head, fast = head;
		Stack<ListNode> s = new Stack<>();
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		while (slow != null) {
			s.push(slow);
			slow = slow.next;
		}

		slow = head;
		while (!s.isEmpty()) {
			fast = s.pop();
			fast.next = slow.next;
			slow.next = fast;
			slow = fast.next;
		}
		slow.next = null;
	}

}
