import java.util.*;

public class FlatenBinaryTree {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(0);
		flatten(t);
	}

	public static void flatten(TreeNode root) {
		Queue<TreeNode> list = new LinkedList<TreeNode>();
		visit(root, list);

		TreeNode vRoot = new TreeNode(0);
		while (list.size() > 0) {
			vRoot.left = null;
			vRoot.right = list.poll();
			vRoot = vRoot.right;
		}
	}

	public static void visit(TreeNode t, Queue<TreeNode> list) {
		if (t == null) {
			return;
		}
		list.add(t);
		visit(t.left, list);
		t.left = null;
		visit(t.right, list);
		t.right = null;
	}
}
