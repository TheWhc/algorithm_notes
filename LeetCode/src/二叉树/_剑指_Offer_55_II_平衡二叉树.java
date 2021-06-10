package 二叉树;

/**
 * @ClassName: _剑指_Offer_55_II_平衡二叉树
 * @Author: whc
 * @Date: 2021/04/18/9:39
 */
public class _剑指_Offer_55_II_平衡二叉树 {

	// 时间复杂度O(nlogn)
	// 空间复杂度O(n) 最差退化为链表
	// 先序遍历 + 判断深度
	/*public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int getDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
	}*/

	// 后序遍历 + 剪枝
	// 时间O(N)
	// 空间O(N) 退化为链表
	public boolean isBalanced(TreeNode root) {
		return getDepth(root) == -1 ? false : true;
	}

	private int getDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		// 左
		int left = getDepth(node.left);
		if(left == -1) {
			// 剪枝
			return -1;
		}
		// 右
		int right = getDepth(node.right);
		if(right == -1) {
			return -1;
		}
		// 根
		return Math.abs(left-right) <= 1 ? Math.max(left, right) + 1 : -1;
	}
}
