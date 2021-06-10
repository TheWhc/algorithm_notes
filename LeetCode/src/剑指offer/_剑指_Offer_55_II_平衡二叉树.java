package 剑指offer;

/**
 * @ClassName: _剑指_Offer_55_II_平衡二叉树
 * @Author: whc
 * @Date: 2021/06/05/12:41
 */
public class _剑指_Offer_55_II_平衡二叉树 {

	/**
	 *  思路: 递归
	 *  1. 根节点的左子树和右子树的高度差的绝对值要 <= 1
	 *  2. 要保证左子树和右子树都是平衡!!
	 */
	/*public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}*/

	/**
	 *  思路: 后序 + 剪枝
	 */
	public boolean isBalanced(TreeNode root) {
		 if(root == null) return true;
		 if(dfs(root) == -1) {
		 	return false;
		 } else {
		 	return true;
		 }
	}

	private int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = dfs(root.left);
		if(left == -1) {
			return -1;
		}
		int right = dfs(root.right);
		if(right == -1) {
			return -1;
		}
		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
	}
}
