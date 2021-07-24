package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _226_翻转二叉树
 * @Author: whc
 * @Date: 2021/07/24/16:31
 */
public class _226_翻转二叉树 {

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

	// 栈迭代
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			swap(node, node.left, node.right);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}

		return root;
	}

	private void swap(TreeNode root, TreeNode left, TreeNode right) {
		root.left = right;
		root.right = left;
	}
}
