package 二叉树.二叉树的属性;

import java.util.LinkedList;

/**
 * @ClassName: _111_二叉树的最小深度
 * @Author: whc
 * @Date: 2021/06/21/11:09
 */
public class _111_二叉树的最小深度 {

	/**
	 *  思路: 递归法
	 *  注意一点: 不能按照最大深度的方式,因为最小深度中可能出现左子树为空,右子树不为空的情况,此时最小深度并不是直接等于1(根),而是右子树的深度 + 1(根)
	 */
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		// 左子树为空,返回右子树的最小深度+1
		if(root.left == null) {
			return minDepth(root.right) + 1;
		}

		// 右子树为空,返回左子树的最小深度+1
		if(root.right == null) {
			return minDepth(root.left) + 1;
		}

		// 左右子树不为空,返回左右子树的最小深度+1
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	/**
	 *  思路: 迭代法(层序遍历)
	 */
	/*public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int res = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null) {
					return res + 1;
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
			res++;
		}

		return res+1;
	}*/
}
