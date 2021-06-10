package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _530_二叉搜索树的最小绝对差
 * @Author: whc
 * @Date: 2021/04/21/12:00
 */
public class _530_二叉搜索树的最小绝对差 {

	/*List<Integer> list = new ArrayList<>();

	public int getMinimumDifference(TreeNode root) {
		// 思路: 先转化为有序数组
		dfs(root);
		int minVal = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			int tmp = list.get(i) - list.get(i-1);
			minVal = Math.max(tmp, minVal);
		}

		return minVal;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.left);
		list.add(root.val);
		dfs(root.right);
	}*/

	// 用一个pre结点记录一下cur结点的前一个结点
	/*int res = Integer.MAX_VALUE;
	TreeNode pre = null;
	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode cur) {
		if(cur == null) return;

		// 中序遍历 左根右
		dfs(cur.left); // 左
		if(pre != null) { // 根
			res = Math.min(cur.val - pre.val, res);
		}
		pre = cur;
		dfs(cur.right); // 右
	}*/

	// 迭代法
	public int getMinimumDifference(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		TreeNode pre = null;
		int res = Integer.MAX_VALUE;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.add(cur);
				cur = cur.left; // 左
			} else {
				cur = stack.pop();
				if(pre != null) {  // 根
					res = Math.min(res, cur.val - pre.val);
				}
				pre = cur;
				cur = cur.right; // 右
			}
		}

		return res;
	}
}
