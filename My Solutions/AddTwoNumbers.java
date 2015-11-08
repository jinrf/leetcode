import java.util.*;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> s1 = new ArrayDeque<>();
		Deque<Integer> s2 = new ArrayDeque<>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int carry = 0;
		ListNode tail = null;
		while (!s1.isEmpty() || !s2.isEmpty()) {

			int op1 = s1.isEmpty() ? 0 : s1.pop();
			int op2 = s2.isEmpty() ? 0 : s2.pop();
			int sum = op1 + op2 + carry;
			ListNode n = new ListNode(sum);
			n.next = tail;
			tail = n;
			carry = sum >= 10 ? 1 : 0;
		}
		if (carry == 1) {
			ListNode n = new ListNode(1);
			n.next = tail;
			tail = n;
		}
		return tail;
	}

}
