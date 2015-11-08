public class PopulatingNextRightPointerInEachNodeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeLinkNode root = new TreeLinkNode(0);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(4);
		root.left.left = new TreeLinkNode(1);
		root.right.left = new TreeLinkNode(3);
		root.right.right = new TreeLinkNode(-1);
		root.left.left.left = new TreeLinkNode(5);
		root.left.left.right = new TreeLinkNode(1);
		root.right.left.right = new TreeLinkNode(6);
		root.right.right.right = new TreeLinkNode(8);

		connect(root);
		return;

	}

	public static void connect(TreeLinkNode root) {
		TreeLinkNode tempChild = new TreeLinkNode(0);
		while (root != null) {
			tempChild.next = null;

			TreeLinkNode currentChild = tempChild;
			while (root != null) {
				if (root.left != null) {
					currentChild.next = root.left;
					currentChild = currentChild.next;
				}
				if (root.right != null) {
					currentChild.next = root.right;
					currentChild = currentChild.next;
				}
				root = root.next;
			}
			root = tempChild.next;
		}
	}

	public static void connect1(TreeLinkNode root) {
		TreeLinkNode left = root;

		while (left != null) {

			TreeLinkNode curr = left;
			left = null;
			while (curr != null) {
				if (left == null & curr.left != null) {
					left = curr.left;
					if (curr.right != null)
						curr.left.next = curr.right;
					if (curr.right == null && curr.next != null)
						curr.left.next = curr.next.left == null ? curr.next.right
								: curr.next.left;
				}
				if (left == null & curr.right != null) {
					left = curr.right;
					if (curr.next != null)
						curr.right.next = curr.next.left == null ? curr.next.right
								: curr.next.left;
				}
				curr = curr.next;
			}
		}
	}

}
