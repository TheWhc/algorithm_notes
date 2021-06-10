package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._98_验证二叉搜索树
 * @Author: whc
 * @Date: 2021/04/21/9:58
 */
public class _98_验证二叉搜索树 {

	// 递归法
	// 中序遍历
	/*List<Integer> list = new ArrayList<>();
	public boolean isValidBST(TreeNode root) {
		dfs(root);
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) < list.get(i-1)) {
				return false;
			}
		}

		return true;
	}

	// 左根右
	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.left);
		list.add(root.val);
		dfs(root.right);
	}*/


	/*long maxVal = Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}

		boolean left = isValidBST(root.left);
		if(root.val > maxVal) {
			maxVal = root.val;
		} else {
			return false;
		}
		boolean right = isValidBST(root.right);

		return left && right;
	}*/

	/*TreeNode pre = null;
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}

		boolean left = isValidBST(root.left);
		if(pre != null && pre.val >= root.val) {
			return false;
		}
		pre = root;

		boolean right = isValidBST(root.right);

		return left && right;
	}*/

	// 迭代法 中序遍历 栈与队列 + 指针
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		TreeNode pre = null; // 记录前一个结点
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.add(cur);
				cur = cur.left; // 左
			} else {
				cur  = stack.pop();  // 根
				if(pre != null && cur.val < pre.val) {
					return false;
				}
				pre = cur;
				cur = cur.right; // 右
			}
		}

		return true;
	}
}
