import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> listlist = new ArrayList<List<Integer>>();

		if (root == null) {
			return listlist;
		}

		if (root.left == null && root.right == null) {

			if (root.val == sum) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(root.val);
				listlist.add(list);
			}

		} else {
			List<List<Integer>> ll1 = pathSum(root.left, sum - root.val);
			List<List<Integer>> ll2 = pathSum(root.right, sum - root.val);
			for (List<Integer> l : ll1) {
				l.add(0, root.val);
				listlist.add(l);
			}
			;
			for (List<Integer> l : ll2) {
				l.add(0, root.val);
				listlist.add(l);
			}
			;
		}

		return listlist;
	}
}
