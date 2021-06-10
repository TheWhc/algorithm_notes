package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: 待分类._101_对称二叉树
 * @Author: whc
 * @Date: 2021/04/17/9:00
 */
public class _101_对称二叉树 {

	/*public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		return symmetric(root.left, root.right);
	}

	// 递归法
	private boolean symmetric(TreeNode left, TreeNode right) {
		// 递归终止条件
		if(left == null && right == null) {
			return true;
		} else if(left == null || right == null) {
			return false;
		} else if(left.val != right.val) {
			return false;
		}

		// 单层递归逻辑
		boolean outside = symmetric(left.left, right.right);
		boolean inside = symmetric(left.right, right.left);

		return outside && inside;
	}*/


	// 迭代法 (队列)
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty()) {
			TreeNode left = queue.pop();
			TreeNode right = queue.pop();
			// 左右都为空时
			if(left == null && right == null) {
				continue;
			} else if(left == null || right == null) {
				return false;
			} else if(left.val != right.val) {
				return false;
			}
			queue.push(left.left);
			queue.push(right.right);
			queue.push(left.right);
			queue.push(right.left);
		}
		return true;
	}
}
