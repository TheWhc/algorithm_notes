package CodeTop;

import java.util.LinkedList;

/**
 * @ClassName: _101_对称二叉树
 * @Author: whc
 * @Date: 2021/07/24/15:08
 */
public class _101_对称二叉树 {

	// 递归法(忽略根节点)
/*	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		return symmetric(root.left, root.right);
	}

	private boolean symmetric(TreeNode left, TreeNode right) {
		if(left == null) {
			return right == null;
		}

		if(right == null) {
			return left == null;
		}

		if(left.val != right.val) {
			return false;
		}

		return symmetric(left.left, right.right) && symmetric(left.right, right.left);
	}*/

	// 迭代法
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node1 = queue.poll();
				TreeNode node2 = queue.poll();

				if(node1 == null && node2 != null) {
					return false;
				} else if(node1 != null && node2 == null) {
					return false;
				} else if(node1 == null && node2 == null) {
					levelSize -= 2;
					continue;
				} else if(node1.val != node2.val) {
					return false;
				}
				queue.offer(node1.left);
				queue.offer(node2.right);
				queue.offer(node1.right);
				queue.offer(node2.left);
				levelSize -= 2;
			}
		}

		return true;
	}
}
