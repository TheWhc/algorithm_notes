package 二叉树;

import java.util.Stack;

/**
 * @ClassName: _538_把二叉搜索树转换为累加树
 * @Author: whc
 * @Date: 2021/04/23/8:48
 */
public class _538_把二叉搜索树转换为累加树 {

	/*int pre = 0;
	public TreeNode convertBST(TreeNode root) {
		if(root == null) return null;

		dfs(root);
		return root;
	}

	// 反中序遍历 右根左
	private void dfs(TreeNode cur) {
		if(cur == null) return;

		dfs(cur.right);
		cur.val += pre;
		pre = cur.val;
		dfs(cur.left);
	}*/


	// 反中序遍历迭代法   右根左
	// 栈与队列 + 指针
	public TreeNode convertBST(TreeNode root) {
		if(root == null) return null;
		int pre = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.right;
			} else {
				cur = stack.pop();
				cur.val += pre;
				pre = cur.val;
				cur = cur.left;
			}
		}

		return root;
	}

}
