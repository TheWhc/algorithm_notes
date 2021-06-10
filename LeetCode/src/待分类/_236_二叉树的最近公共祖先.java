package 待分类;

/**
 * @ClassName: 待分类._236_二叉树的最近公共祖先
 * @Author: whc
 * @Date: 2021/03/15/15:18
 */
public class _236_二叉树的最近公共祖先 {

	// 回溯
	// 需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从低向上的遍历方式。
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == p || root == q || root == null) return root;

		// 使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) {
			return root;
		} else if(left == null && right != null) {
			return right;
		} else if(right == null && left != null) {
			return left;
		} else { // left == null && right == null)
			return null;
		}
	}
}
