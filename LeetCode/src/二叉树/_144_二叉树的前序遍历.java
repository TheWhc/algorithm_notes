package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._144_二叉树的前序遍历
 * @Author: whc
 * @Date: 2021/04/15/11:02
 */
public class _144_二叉树的前序遍历 {
	/*List<Integer> res = new ArrayList<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		// 递归终止条件
		if(root == null) {
			return;
		}

		// 根左右
		res.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}*/


	// 迭代法
	// 利用栈
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop(); // 根
			res.add(node.val);
			if(node.right != null) {
				stack.push(node.right); // 右
			}
			if(node.left != null) {
				stack.push(node.left); // 左
			}
		}

		return res;
	}
}
