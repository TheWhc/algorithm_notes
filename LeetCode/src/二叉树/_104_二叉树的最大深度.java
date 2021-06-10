package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: 待分类._104_二叉树的最大深度
 * @Author: whc
 * @Date: 2021/04/17/9:36
 */
public class _104_二叉树的最大深度 {

	// 递归法
	/*public int maxDepth(TreeNode root) {
		return getDepth(root);
	}

	// 最大深度 ==> 求最大高度 ==> 即求root的高度
	private int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		return Math.max(left, right) + 1;
	}*/

	// 迭代法
	public int maxDepth(TreeNode root) {
		// 层序遍历
		if(root == null) {
			return 0;
		}

		int res = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			count = queue.size();
			while(count > 0) {
				TreeNode node = queue.poll();
				res++;
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}
		return res;
	}
}
