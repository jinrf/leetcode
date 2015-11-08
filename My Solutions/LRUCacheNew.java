import java.util.*;

public class LRUCacheNew {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, DListNode> map;
	int capacity;
	DListNode head, tail;

	public LRUCacheNew(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		head = new DListNode(-1);
		tail = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DListNode node = map.get(key);
			removeNode(node);
			addToHead(node);
			return node.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			DListNode node = map.get(key);
			removeNode(node);
			addToHead(node);
		} else {
			DListNode node = new DListNode(value);
			if (map.size() >= capacity) {
				map.remove(key);
				removeTailNode();
			}
			addToHead(node);
			map.put(key, node);
		}
	}

	private void addToHead(DListNode node) {
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}

	private void removeNode(DListNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	private void removeTailNode() {
		tail = tail.pre;
	}

	class DListNode {
		int value;
		DListNode pre = null;
		DListNode next = null;

		DListNode(int value) {
			this.value = value;
		}
	}

}
