package 待分类;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 待分类._101_对称二叉树
 * @Author: whc
 * @Date: 2021/03/23/21:27
 */
public class _101_对称二叉树 {

	/*public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		// 1. 递归函数参数和返回值
		return symmetric(root.left, root.right);
	}

	private boolean symmetric(TreeNode left, TreeNode right) {
		// 2. 递归终止条件
		if(left == null && right != null) {
			return false;
		} else if(left != null && right == null) {
			return false;
		} else if(left == null && right == null) {
			return true;
		} else if(left.val != right.val) {
			return false;
		}

		// 3. 单层递归逻辑
		boolean outside = symmetric(left.left, right.right);
		boolean inside = symmetric(left.right, right.left);
		return outside && inside;
	}*/

	// 迭代法
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty()) {
			TreeNode leftNode = queue.pop();
			TreeNode rightNode = queue.pop();
			if(leftNode == null && rightNode == null) {
				continue;
			}

			if(leftNode == null && rightNode != null || rightNode == null && leftNode != null) {
				return false;
			} else if(leftNode.val != rightNode.val) {
				return false;
			}

			queue.add(leftNode.left);
			queue.add(rightNode.right);
			queue.add(leftNode.right);
			queue.add(rightNode.left);
		}
		return true;
	}
}
