import java.util.*;

public class RightSideView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RightSideView rsv = new RightSideView();
		
		TreeNode root = new TreeNode(1);
		
		rsv.rightSideView(root);

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		if (root == null)
			return ret;

		List<TreeNode> curr = new LinkedList<>();
		curr.add(root);
		ret.add(root.val);

		while (!curr.isEmpty()) {
			LinkedList<TreeNode> next = new LinkedList<>();
			while (!curr.isEmpty()) {
				TreeNode tmp = curr.remove(0);
				if (tmp.left != null)
					next.add(tmp.left);
				if (tmp.right != null)
					next.add(tmp.right);
			}
			ret.add(next.getLast().val);
			curr = next;
		}
		return ret;
	}

}
