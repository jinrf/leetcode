import java.util.*;

public class ConvertSortedListToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode n = new ListNode(1);
		n.next = new ListNode(3);

		TreeNode t = sortedListToBST(n);

		return;

	}

	public static TreeNode sortedListToBST(ListNode head) {

		int listCount = 0;
		ListNode p = head;
		while (p != null) {
			listCount++;
			p = p.next;
		}

		if (listCount == 0)
			return null;

		// construct the tree
		int level = (int) (Math.log(listCount) / Math.log(2)) + 1;
		TreeNode root = new TreeNode(-1);
		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);
		int nodeCount = 1;
		for (int i = 0; i < level - 1; i++) {
			Queue<TreeNode> nextQ = new ArrayDeque<>();
			while (q.peek() != null) {
				TreeNode tmp = q.remove();
				if (nodeCount++ < listCount)
					nextQ.add(tmp.left = new TreeNode(-1));
				else {
					i = level;
					break;
				}
				if (nodeCount++ < listCount)
					nextQ.add(tmp.right = new TreeNode(-1));
				else {
					i = level;
					break;
				}
			}
			q = nextQ;
		}

		DFS(root, head);
		return root;
	}

	private static ListNode DFS(TreeNode root, ListNode head) {

		if (root.left == null && root.right == null) {
			root.val = head.val;
			head = head.next;
			return head;
		}

		if (root.left != null) {
			head = DFS(root.left, head);
		}
		root.val = head.val;
		head = head.next;
		if (root.right != null) {
			head = DFS(root.right, head);
		}

		return head;

	}

	

}
