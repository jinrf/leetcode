import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		return mapCopy(head);
	}

	public RandomListNode mapCopy(RandomListNode head) {

		if (head == null)
			return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		RandomListNode headCopy = new RandomListNode(head.label);
		RandomListNode p = head, q = headCopy;

		while (p != null) {
			if (p.random == null) {
				q.random = null;
			} else if (map.containsKey(p.random)) {
				q.random = map.get(p.random);
			} else {
				map.put(p.random, new RandomListNode(p.random.label));
			}

			if (p.next == null) {
				q.next = null;
			} else if (map.containsKey(p.next)) {
				q.next = map.get(p.next);
			} else {
				map.put(p.next, new RandomListNode(p.next.label));
			}

			p = p.next;
			q = q.next;
		}

		return headCopy;

	}
}
