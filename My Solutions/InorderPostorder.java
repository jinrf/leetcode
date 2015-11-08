public class InorderPostorder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InorderPostorder ip = new InorderPostorder();
		TreeNode t = ip.buildTree(new int[] { 1, 2}, new int[] {2, 1 });
		return;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length, postorder, 0,
				inorder.length); // end exclusive

	}

	private TreeNode buildTree(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        int len = e1 - s1;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(inorder[0]);
        
        int rootVal = postorder[e2 - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootLoc = -1;
        for (int i = 0; i < len; i++) {
            if (inorder[s1 + i] == rootVal) {
                rootLoc = s1 + i;
                break;
            }
        }
        
        int leftLen = rootLoc - s1;
        int rightLen = e1 - rootLoc - 1;
        
        root.left = buildTree(inorder, s1, rootLoc, postorder, s2, s2 + leftLen); // end exclusive
        root.right = buildTree(inorder, rootLoc + 1, e1, postorder, s2 + leftLen, s2 + leftLen + rightLen); // end exclusive     
        
        return root;
    }

}
