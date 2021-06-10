package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_27_二叉树的镜像
 * @Author: whc
 * @Date: 2021/05/28/10:40
 */
public class _剑指_Offer_27_二叉树的镜像 {

	/**
	 *  思路: dfs/递归
	 *  后序遍历 先局部翻转后整体
	 *	1. 特判: 如果root为空,则返回
	 *  2. 把root的左子树放到mirrorTree中镜像一下
	 *  3. 把root的右子树放到mirrorTree中镜像一下
	 *  4. 交换左右子树
	 *
	 *  先交换还是先镜像都可以,先交换则是前序遍历,先镜像则是后序遍历
	 *  时间:O(n) n为树的节点个数
	 *  空间:O(h) h为树的深度
	 */
	/*public TreeNode mirrorTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode leftTree = mirrorTree(root.left);
		TreeNode rightTree = mirrorTree(root.right);
		root.left = rightTree;
		root.right = leftTree;
		return root;
	}*/

	/*public TreeNode mirrorTree(TreeNode root) {
		if(root == null) {
			return root;
		}

		root.left = mirrorTree(root.left);
		root.right = mirrorTree(root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		return root;
	}*/

	// 前序遍历 先整体后局部翻转
	 /*public TreeNode mirrorTree(TreeNode root) {
	 	if(root == null) {
	 		return root;
	 	}
	    TreeNode tmp = root.left;
	 	root.left = root.right;
	 	root.right = tmp;
	 	mirrorTree(root.left);
	 	mirrorTree(root.right);
	 	return root;
	 }*/

	/**
	 *  思路: bfs
	 *  层序遍历
	 *  只要遍历到所有节点并且对每个节点都交换一下左右子树
	 *  先交换还是先加入队列都可以，不影响最终结果
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}

		return root;
	}
}
