package CodeTop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _145_二叉树的后序遍历
 * @Author: whc
 * @Date: 2021/07/26/11:31
 */
public class _145_二叉树的后序遍历 {

	/*List<Integer> res = new ArrayList<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}

		dfs(root.left);
		dfs(root.right);
		res.add(root.val);
	}*/

	// 前序遍历(根右左) + 反转
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);

			if(node.left != null) {
				stack.push(node.left);
			}

			if(node.right != null) {
				stack.push(node.right);
			}
		}

		Collections.reverse(res);

		return res;
	}
}
