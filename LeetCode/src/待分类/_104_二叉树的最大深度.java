package 待分类;

/**
 * @ClassName: 待分类._104_二叉树的最大深度
 * @Author: whc
 * @Date: 2021/03/17/18:37
 */
public class _104_二叉树的最大深度 {

	// 最大深度可以用后序遍历计算 左右根
	public int maxDepth(TreeNode root) {
		return getDepth(root);
	}

	// 求树的高度
	private int getDepth(TreeNode root) {
		if(root == null)
			return 0;

		// 左
		int leftDepth = getDepth(root.left);
		// 右
		int rightDepth = getDepth(root.right);

		// 根 单层递归逻辑
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
