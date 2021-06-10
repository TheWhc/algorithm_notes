package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: _222_完全二叉树的节点个数
 * @Author: whc
 * @Date: 2021/04/17/11:13
 */
public class _222_完全二叉树的节点个数 {
	// 迭代法 层序遍历
	/*public int countNodes(TreeNode root) {
		if(root == null) return 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int res = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				TreeNode node = queue.pop();
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

	// 递归法
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		return left + right + 1;
	}
}
