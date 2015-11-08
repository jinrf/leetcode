import java.util.*;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		if (root == null) {
			return null;
		}

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		Queue<TreeNode> children = new LinkedList<TreeNode>();
		children.add(root);
		while (true) {
			List<Integer> level = new ArrayList<Integer>();
			Queue<TreeNode> grandChildren = new LinkedList<TreeNode>();

			while (children.size() > 0) {
				TreeNode child = children.poll();
				level.add(child.val);
				if (child.left != null) {
					grandChildren.add(child.left);
				}
				if (child.right != null) {
					grandChildren.add(child.right);
				}
			}
			results.add(level);
			if (grandChildren.size() == 0) {
				return results;
			}
		}
	}
}
