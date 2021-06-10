package 待分类;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._144_二叉树的前序遍历
 * @Author: whc
 * @Date: 2021/03/07/11:32
 */
public class _144_二叉树的前序遍历 {
	// 根左右
	/*private List<Integer> res = new ArrayList<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}
		res.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}*/

	// 前序遍历 迭代法
	/*public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop(); // 根
			if(node != null) {
				list.add(node.val);
			} else {
				continue;
			}
			stack.push(node.right); // 右
			stack.push(node.left);  // 左
		}
		return list;
	}*/
}
