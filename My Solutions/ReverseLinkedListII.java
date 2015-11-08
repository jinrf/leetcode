public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);

		//ListNode rst = reverseBetween(a, 2, 3);
		ListNode rst = iterativeReverse(a);

		while (rst != null) {
			System.out.println(rst.val);
			rst = rst.next;
		}

	}
	
	public static ListNode iterativeReverse(ListNode curr){
		
		ListNode prev = null;
		ListNode next = null;
		
		while (curr != null){
			next = curr.next;
			curr.next=prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
		
	}
	
	public static ListNode recursiveReverse(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode curr = head;
		ListNode next = curr.next;
		//curr.next = null;
		
		ListNode reversedHead = recursiveReverse(next);
		next.next = curr;
		
		
		return reversedHead;
		
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n) {
			return head;
		}

		ListNode vHead = new ListNode(-1);
		vHead.next = head;

		ListNode pre = vHead;
		
		n = n - m;
		
		while (--m > 0) {
			pre = pre.next;
		}

		

		ListNode cur = pre.next;
		ListNode next = cur.next;

		while (n-- > 0) {
			ListNode nn = next.next;
			next.next = cur;
			cur = next;
			next = nn;
		}

		ListNode oldStart = pre.next;
		pre.next = cur;
		oldStart.next = next;

		return vHead.next;

	}

}