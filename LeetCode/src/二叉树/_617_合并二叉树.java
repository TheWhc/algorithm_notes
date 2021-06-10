package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: _617_合并二叉树
 * @Author: whc
 * @Date: 2021/04/21/8:49
 */
public class _617_合并二叉树 {

	// 递归
	/*public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null) {
			return root2;
		}

		if(root2 == null) {
			return root1;
		}
		// 前序遍历
		root1.val += root2.val;
		TreeNode leftTree = mergeTrees(root1.left, root2.left);
		TreeNode rightTree = mergeTrees(root1.right, root2.right);
		root1.left = leftTree;
		root1.right = rightTree;

		return root1;
	}*/

	// 迭代
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null) {
			return root2;
		}
		if(root2 == null) {
			return root1;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root1);
		queue.add(root2);
		while(!queue.isEmpty()) {
			TreeNode node1 = queue.pop();
			TreeNode node2 = queue.pop();
			node1.val += node2.val;

			if(node1.left != null && node2.left != null) {
				queue.add(node1.left);
				queue.add(node2.left);
			}

			if(node1.right != null && node2.right != null) {
				queue.add(node1.right);
				queue.add(node2.right);
			}

			if(node1.left == null && node2.left != null) {
				node1.left = node2.left;
			}

			if(node1.right == null && node2.right != null) {
				node1.right = node2.right;
			}
		}

		return root1;
	}
}
