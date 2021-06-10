package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: 待分类._111_二叉树的最小深度
 * @Author: whc
 * @Date: 2021/04/17/10:27
 */
public class _111_二叉树的最小深度 {
	// 层序遍历
	/*public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int res = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				TreeNode node = queue.pop();
				if(node.left == null && node.right == null) {
					return res;
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res++;
		}
		return res;
	}*/


	public int minDepth(TreeNode root) {
		return getMinDepth(root) + 1;
	}

	private int getMinDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right != null) {
			return getMinDepth(root.right) + 1;
		}
		if(root.left != null && root.right == null) {
			return getMinDepth(root.left) + 1;
		}
		int left = getMinDepth(root.left);
		int right = getMinDepth(root.right);
		return Math.min(left, right) + 1;
	}
}
