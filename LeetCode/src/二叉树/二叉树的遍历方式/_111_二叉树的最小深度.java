package 二叉树.二叉树的遍历方式;

import java.util.LinkedList;

/**
 * @ClassName: _111_二叉树的最小深度
 * @Author: whc
 * @Date: 2021/06/20/15:34
 */
public class _111_二叉树的最小深度 {


	/**
	 *  思路: 层序遍历(队列,广度优先搜索)
	 *
	 *  1. 按照层序遍历的思路
	 *  2. 一旦在某一层遇到节点的左右节点都为空,说明到达了叶子节点了,直接返回结果
	 *  3. 不然的话,就一直层序到最后一层
	 */
	public int minDepth(TreeNode root) {
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
	}
}
