package 二叉树.二叉树的属性;

import java.util.Stack;

/**
 * @ClassName: _538_把二叉搜索树转换为累加树
 * @Author: whc
 * @Date: 2021/06/24/14:34
 */
public class _538_把二叉搜索树转换为累加树 {

	/**
	 * 思路: 反中序遍历
	 *
	 * 单层递归逻辑
	 * 当前节点的值 + 之前节点累加的值preVal
	 */
	/*int preVal = 0;
	public TreeNode convertBST(TreeNode root) {
		dfs(root);
		return root;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}

		dfs(root.right);
		root.val = root.val + preVal;

		preVal = root.val;
		dfs(root.left);
	}*/

	/**
	 * 思路: 迭代法
	 *
	 * 按照反中序遍历的迭代法
	 * 出栈元素的元素 记得 累加上之前的值
	 *
	 */
	public TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return null;
		}
		int preVal = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.right;
			} else {
				TreeNode node = stack.pop();
				node.val = node.val + preVal;
				preVal = node.val;
				cur = node.left;
			}
		}
		return root;
	}
}
