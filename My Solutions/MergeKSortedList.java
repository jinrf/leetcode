import java.util.List;

public class MergeKSortedList {


	public ListNode mergeKLists(List<ListNode> lists) {

		int len = lists.size();

		if (len == 0) {
			return null;
		} else if (len == 1) {
			return lists.get(0);
		} else if (len == 2) {
			return mergeSort(lists.get(0), lists.get(1));
		} else {
			return mergeSort(mergeKLists(lists.subList(0, len / 2)),
					mergeKLists(lists.subList(len / 2, len)));
		}

	}

	public ListNode mergeSort(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(-1);
		ListNode end = head;

		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				end.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				end.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			end = end.next;
		}

		if (l1 == null) {
			end.next = l2;
		}
		if (l2 == null) {
			end.next = l1;
		}

		return head.next;
	}
}