package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_55_I_二叉树的深度
 * @Author: whc
 * @Date: 2021/06/05/11:29
 */
public class _剑指_Offer_55_I_二叉树的深度 {

	/**
	 *  思路: 递归法
	 */
	/*public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}*/

	/**
	 *	思路: bfs迭代法
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int res = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
			res++;
		}
		return res;
	}

}
