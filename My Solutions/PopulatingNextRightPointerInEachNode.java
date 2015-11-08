import java.util.*;

public class PopulatingNextRightPointerInEachNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode root) {

		sol2(root);
		// sol1(root);
	}

	private void sol2(TreeLinkNode root) {

		TreeLinkNode left = root;
		while (left != null) {
			TreeLinkNode curr = left;
			while (curr != null) {
				if (curr.left != null)
					curr.left.next = curr.right;
				if (curr.right != null && curr.next != null)
					curr.right.next = curr.next.left;
				curr = curr.next;
			}
			left = left.left;
		}
	}

	private void sol1(TreeLinkNode root) {
		if (root == null || root.left == null && root.right == null)
			return;

		Queue<TreeLinkNode> currQ = new LinkedList<>();
		Queue<TreeLinkNode> newQ;
		currQ.add(root);

		while (!currQ.isEmpty()) {
			newQ = new LinkedList<>();
			TreeLinkNode currN;
			while ((currN = currQ.poll()) != null) {
				if (currN.left != null)
					newQ.add(currN.left);
				if (currN.right != null)
					newQ.add(currN.right);
				currN.next = currQ.peek();
			}
			currQ = newQ;
		}
	}
}
