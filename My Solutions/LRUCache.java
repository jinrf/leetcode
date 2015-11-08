import java.util.*;

public class LRUCache {

	private int capacity = 0;
	private DlinkedNode head;
	private DlinkedNode tail;
	private Map<Integer, DlinkedNode> map;

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(1);
		lru.set(2, 1);
		lru.get(2);
		lru.set(3, 2);
		lru.get(2);
		lru.get(3);
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;

		head = new DlinkedNode();
		tail = new DlinkedNode();
		head.next = tail;
		tail.pre = head;

		map = new HashMap<Integer, DlinkedNode>();

	}

	public int get(int key) {
		DlinkedNode node = map.get(key);
		if (node != null) {
			removeNode(node);
			addToHead(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		DlinkedNode node = map.get(key);
		if (node != null) {
			removeNode(node);
			addToHead(node);
		} else {
			node = new DlinkedNode();
			node.key = key;
			node.value = value;
			
			if (map.size() < capacity) {
				addToHead(node);
			} else {
				removeNode(tail.pre);
				addToHead(node);
			}
		}
		return;
	}

	private void removeNode(DlinkedNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
		map.remove(node.key);
	}

	private void addToHead(DlinkedNode node) {
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		node.pre = head;
		map.put(node.key, node);
	}
}

class DlinkedNode {
	int key;
	int value;
	DlinkedNode pre = null;
	DlinkedNode next = null;
}