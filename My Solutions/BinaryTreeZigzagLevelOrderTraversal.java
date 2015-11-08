import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> levelOrder = new LinkedList<>();
		recursive(root, levelOrder, 0);
		adjust(levelOrder);
		return levelOrder;
	}

	private void recursive(TreeNode root, List<List<Integer>> levelOrder,
			int level) {
		if (root == null)
			return;
		if (level > levelOrder.size()) {
			levelOrder.add(new LinkedList<Integer>());
		}
		levelOrder.get(level).add(root.val);
		recursive(root.left, levelOrder, level + 1);
		recursive(root.right, levelOrder, level + 1);
	}

	private void adjust(List<List<Integer>> levelOrder) {
		for (int i = 0; i < levelOrder.size(); i++) {
			if ((i & 1) == 1) {
				Collections.reverse(levelOrder.get(i));
			}
		}
		return;
	}

	private List<List<Integer>> naive(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<>();
		if (root == null)
			return ret;

		List<Integer> levelList = new LinkedList<>();
		levelList.add(root.val);
		ret.add(levelList);

		Deque<TreeNode> q = new ArrayDeque<>();

		q.add(root);
		int level = 0;
		while (q.size() > 0) {
			level++;
			levelList = new LinkedList<>();
			Deque<TreeNode> newQ = new ArrayDeque<>();
			while (q.size() > 0) {
				TreeNode n = q.remove();
				if (n.left != null) {
					newQ.add(n.left);
					if (level % 2 == 1)
						levelList.add(0, n.left.val);
					else
						levelList.add(n.left.val);
				}
				if (n.right != null) {
					newQ.add(n.right);
					if (level % 2 == 1)
						levelList.add(0, n.right.val);
					else
						levelList.add(n.right.val);
				}
			}
			if (levelList.size() > 0)
				ret.add(levelList);
			q = newQ;
		}
		return ret;
	}

}
