package 二叉树.二叉树公共祖先问题;

/**
 * @ClassName: _236_二叉树的最近公共祖先
 * @Author: whc
 * @Date: 2021/06/24/9:17
 */
public class _236_二叉树的最近公共祖先 {

	/**
	 * 思路: 递归
	 *
	 * 1. 递归函数的返回值以及参数的确定
	 * TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	 * 有返回值为TreeNode
	 * 但是需要对返回值做进一步的逻辑判断,因为我们是遍历整颗二叉树
	 *
	 * 2. 递归终止条件
	 * 当root == null || root == p || root == q
	 * return root
	 *
	 * 3. 单层递归搜索逻辑
	 * 递归判断左子树和右子树,根据返回值进一步判断
	 * 如果左子树返回节点值,右子树没有节点值,则说明左子树返回的节点值为最近公共父节点
	 * 如果右子树返回节点值,左子树没有节点值,则说明右子树返回的节点值为最近公共父节点
	 * 如果左子树返回节点值,右子树也有节点值,则说明此时根节点为最近公共父节点
	 * 如果左子树返回为null,右子树返回也为null,则说明左右子树最近公共父节点为null
	 *
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}

		// 有返回值,需要进一步的逻辑判断,所以是搜索整个树
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right == null) {
			return left;
		} else if(left == null && right != null) {
			return right;
		} else if (left == null && right == null) {
			return null;
		} else {
			// left != null && right != null
			// 都不为空 说明root此时为最近公共父节点
			return root;
		}
	}
}
