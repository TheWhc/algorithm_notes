package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _110_平衡二叉树
 * @Author: whc
 * @Date: 2021/07/22/16:41
 */
public class _110_平衡二叉树 {

	// 递归法(前序遍历)
	/*public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);

		return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int getDepth(TreeNode cur) {
		if(cur == null) {
			return 0;
		}

		return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
	}*/

	// 递归版(后序遍历)
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		boolean left = isBalanced(root.left);
		if(!left) {
			return false;
		}
		boolean right = isBalanced(root.right);
		if(!right) {
			return false;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return Math.abs(leftDepth - rightDepth) <= 1;
	}

	private int getDepth(TreeNode cur) {
		if(cur == null) {
			return 0;
		}

		return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
	}


	// 迭代法 (前序遍历的迭代版)
	/*public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int curDiff = Math.abs(getDepth(node.left) - getDepth(node.right));
			if(curDiff > 1) {
				return false;
			}

			if(node.right != null) {
				stack.add(node.right);
			}
			if(node.left != null) {
				stack.add(node.left);
			}
		}

		return true;
	}


	private int getDepth(TreeNode cur) {
		if(cur == null) {
			return 0;
		}

		return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
	}*/
}
