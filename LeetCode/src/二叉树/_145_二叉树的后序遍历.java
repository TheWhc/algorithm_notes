package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._145_二叉树的后序遍历
 * @Author: whc
 * @Date: 2021/04/15/11:05
 */

public class _145_二叉树的后序遍历 {
	/*List<Integer> res = new ArrayList<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		// 递归终止条件
		if(root == null) {
			return;
		}

		// 左右根
		dfs(root.left);
		dfs(root.right);
		res.add(root.val);
	}*/

	// 迭代遍历
	// 先序遍历: 根左右 —> 根右左 —> 左右根
	/*public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop(); // 根
			res.add(node.val);
			if(node.left != null) {
				stack.push(node.left); // 左
			}
			if(node.right != null) {
				stack.push(node.right); // 右
			}
		}
		Collections.reverse(res);
		return res;
	}*/

	// 2021/5/8
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		// 根右左 反转 就成了 左右根
		// 所以由前序遍历(根右左))  最后对遍历得到的数据进行反转就得到后序遍历(左右根))
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
}