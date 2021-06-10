package 待分类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._145_二叉树的后序遍历
 * @Author: whc
 * @Date: 2021/03/22/15:05
 */
public class _145_二叉树的后序遍历 {

	/*List<Integer> res = new ArrayList<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null)
			return;
		dfs(root.left);
		dfs(root.right);
		res.add(root.val);
	}*/

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node != null) {
				res.add(node.val);
			} else {
				continue;
			}
			stack.push(node.left);
 			stack.push(node.right);
		}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		postorderTraversal(root);
	}
}
