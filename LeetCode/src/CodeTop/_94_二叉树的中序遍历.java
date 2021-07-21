package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _94_二叉树的中序遍历
 * @Author: whc
 * @Date: 2021/07/21/10:36
 */
public class _94_二叉树的中序遍历 {

	// 递归法
	/*List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.left);
		res.add(root.val);
		dfs(root.right);
	}*/

	// 迭代法
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		List<Integer> res = new ArrayList<>();
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.pop();
				res.add(node.val);
				cur = node.right;
			}
		}

		return res;
	}
}
