package CodeTop;

/**
 * @ClassName: _236_二叉树的最近公共祖先
 * @Author: whc
 * @Date: 2021/07/20/14:43
 */
public class _236_二叉树的最近公共祖先 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) {
			return root;
		} else if(left == null && right != null) {
			return right;
		} else if(left != null && right == null) {
			return left;
		} else {
			return null;
		}
	}
}
