package 待分类;

/**
 * @ClassName: 待分类._110_平衡二叉树
 * @Author: whc
 * @Date: 2021/03/17/18:10
 */
public class _110_平衡二叉树 {

	// 求树的高度(自底向上的高度, 所以用后序遍历 左右根)
	public boolean isBalanced(TreeNode root) {
		return getDepth(root) != -1 ? true : false ;
	}

	// 树的高度
	private int getDepth(TreeNode root) {
		if(root == null)
			return 0;

		// 左
		int leftDepth = getDepth(root.left);
		if(leftDepth == -1)
			return -1;
		// 右
		int rightDepth = getDepth(root.right);
		if(rightDepth == -1)
			return -1;

		// 根 单层递归逻辑
		if(Math.abs(rightDepth - leftDepth) > 1) {
			return -1;
		} else {
			return Math.max(leftDepth, rightDepth) + 1;
		}

	}
}
