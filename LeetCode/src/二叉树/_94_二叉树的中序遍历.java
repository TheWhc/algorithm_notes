package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._94_二叉树的中序遍历
 * @Author: whc
 * @Date: 2021/04/15/11:06
 */
public class _94_二叉树的中序遍历 {
	/*List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		// 递归终止条件
		if(root == null) {
			return;
		}

		// 左根右
		dfs(root.left);
		res.add(root.val);
		dfs(root.right);
	}*/


	// 迭代遍历
	/*public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		// 需要借助指针的遍历来帮助访问节点
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left; // 左
			} else {
				cur = stack.pop();
				res.add(cur.val); // 根
				cur = cur.right; // 右
			}
		}
		return res;
	}*/

	// 2021/4/21 练习迭代
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null ||!stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}

		return res;
	}

}
