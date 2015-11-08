public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		rbst.recoverTree(root);
		return;
	}

	TreeNode first = null, second = null,
			prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		sol1(root);
		// sol2(root);
	}

	private void sol2(TreeNode root) { // morris traversal
		TreeNode curr = root, prev = null, tmp;
		while (curr != null) {
			if (curr.left == null) {
				prev = curr;
				curr = curr.right;
			} else {
				tmp = curr.left;
				while (tmp.right != null && tmp.right != curr)
					tmp = tmp.right;
				if (tmp.right == null) {
					tmp.right = curr;
					curr = curr.left;
				} else { // come to the rightmost child
					tmp.right = null;
					prev = curr;
					curr = curr.right;
				}
			}

			if (prev != null && curr != null && prev.val > curr.val) {
				if (first == null) {
					first = prev;
					second = curr;
				} else
					second = curr;
			}
		}

		int t = first.val;
		first.val = second.val;
		second.val = t;

	}

	private void sol1(TreeNode root) {
		traverse(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
		return;
	}

	private void traverse(TreeNode root) {
		if (root == null)
			return;
		traverse(root.left); // inorder traversal

		if (first == null && prev.val > root.val)
			first = prev;
		if (first != null && prev.val > root.val)
			second = root; // swap the smallest with the largest

		prev = root;
		traverse(root.right);
	}

}
