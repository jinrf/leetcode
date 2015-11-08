public class SExpressionOfATree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SExpressionOfATree se = new SExpressionOfATree();
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		System.out.println(se.buildExpression(a));

	}

	String buildExpression(TreeNode root) {
		if (root == null) {
			return "";
		}
		return "(" + root.val + buildExpression(root.left)
				+ buildExpression(root.right) + ")";
	}

}
