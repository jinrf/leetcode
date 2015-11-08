import java.util.*;

public class BinaryTreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(0);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		inorderTraversal(t);

	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Deque<TreeNode> s = new ArrayDeque<>();
		s.push(root);

		while (!s.isEmpty()) {
			TreeNode n = s.pop();
			while (n.left != null) {
				s.push(n);
				n = n.left;
			}
			res.add(n.val);
			if (n.right != null)
				s.push(n.right);
		}
		return res;
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		// recursive(res, root);
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		TreeNode n;
		while (!s.isEmpty()) {
			n = s.pop();
			res.add(n.val);
			if (n.right != null)
				s.push(n.right);
			if (n.left != null)
				s.push(n.left);
		}

		return res;
	}

}
