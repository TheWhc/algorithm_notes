package 二叉树;

import java.util.Stack;

/**
 * @ClassName: 待分类._226_翻转二叉树
 * @Author: whc
 * @Date: 2021/04/16/10:55
 */
public class _226_翻转二叉树 {

	// 递归法
	// 后序遍历(左右根)
	/*public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}*/

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		new _226_翻转二叉树().invertTree(root);
	}

	// 迭代法
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop(); // 根
			swap(node, node.left, node.right);
			if(node.right != null) {
				stack.push(node.right); // 右
			}
			if(node.left != null) {
				stack.push(node.left); // 左
			}
		}

		return root;
	}

	private void swap(TreeNode node, TreeNode left, TreeNode right) {
		node.left = right;
		node.right = left;
	}
}
