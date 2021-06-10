package 二叉树;

/**
 * @ClassName: 待分类._236_二叉树的最近公共祖先
 * @Author: whc
 * @Date: 2021/04/22/9:25
 */
public class _236_二叉树的最近公共祖先 {

	// 需要遍历整个二叉树
	// 后序遍历
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left == null && right != null) {
			return right;
		} else if(left != null && right == null) {
			return left;
		} else if(left != null && right != null) {
			return root;
		} else {
			return null;
		}
	}
}
