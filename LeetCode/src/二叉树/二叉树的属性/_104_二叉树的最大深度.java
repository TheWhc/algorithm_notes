package 二叉树.二叉树的属性;

import java.util.LinkedList;

/**
 * @ClassName: _104_二叉树的最大深度
 * @Author: whc
 * @Date: 2021/06/21/11:00
 */
public class _104_二叉树的最大深度 {

	/**
	 *  思路: 递归法
	 *
	 *  1. 确定递归函数返回值和参数的含义
	 *		int maxDepth(TreeNode root)
	 *		返回值为树的高度
	 *		参数的为当前节点
	 *
	 *  2. 确定终止条件
	 *		节点为空时,返回树深0
	 *
	 *  3. 单层递归逻辑
	 *  	返回左子树和右子树的最大深度 + 1
	 */
	/*public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}*/

	/**
	 *  思路: 迭代法(层序遍历)
	 *	1. 用队列实现层序遍历
	 *  2. 遍历完每一层后res+1
	 *  3. 一直遍历到最后一层
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int res = 0;

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
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

		return res;
	}

}
