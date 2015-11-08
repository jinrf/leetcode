import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesII {

	public static void main(String[] args) {
		RemoveDuplicatesII rd = new RemoveDuplicatesII();

		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		
		printList(test);
		
		ListNode result = rd.deleteDuplicates(test);
		printList (result);

	}

	public static void printList(ListNode l) {
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		return solution2(head);
	}
	
	
	public ListNode solution2(ListNode head){
        if(head == null){
            return null;    // for empty input
        }
        
        ListNode vHead = new ListNode(-100000); // create a virtual start
        ListNode prev = vHead;
        ListNode curr = head;
        
        while(curr != null) {
            boolean isRepeat = false;
            while (curr.next != null && curr.next.val == curr.val){
                isRepeat = true;
                curr=curr.next;
            }
            if(isRepeat){
                prev.next = curr.next;
                isRepeat = false;
            }else{
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        
        return vHead.next;
    }

	public ListNode solution1(ListNode head) {

		Set<Integer> vSet = new HashSet<Integer>();
		Set<Integer> dupSet = new HashSet<Integer>();
		
		ListNode curr = head;
		
		while (curr != null) {

			if (vSet.contains(curr.val)) {
				dupSet.add(curr.val);
			} else {
				vSet.add(curr.val);
			}
			curr = curr.next;
		}

		ListNode vHead = new ListNode(0); // create a virtual head
		ListNode prev = vHead;

		while (head != null) {
			if (!dupSet.contains(head.val)) {
				prev.next = head;
				prev = head;
			}
			head = head.next;
			prev.next = null;
		}

		return vHead.next;
	}
}