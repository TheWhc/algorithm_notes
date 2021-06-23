package 二叉树.求二叉搜索树的属性;

import java.util.Stack;

/**
 * @ClassName: _530_二叉搜索树的最小绝对差
 * @Author: whc
 * @Date: 2021/06/23/14:48
 */
public class _530_二叉搜索树的最小绝对差 {

	/**
	 * 思路: 中序遍历
	 * 构建一个pre节点记录前一个节点, minDiff记录最小差值
	 */
	/*int minDiff = Integer.MAX_VALUE;
	TreeNode pre = null; // 记录前一个节点
	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return minDiff;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}

		dfs(root.left);
		if(pre != null) {
			minDiff = Integer.min(root.val - pre.val, minDiff);
		}
		pre = root;
		dfs(root.right);
	}*/

	/**
	 * 思路: 中序遍历的迭代法
	 *	1. 因为中序遍历的元素的访问顺序和要处理的顺序不一致,所以要设置一个辅助指针帮助访问节点
	 *  2. 栈不为空 或者 当前节点指针cur 不为空的时候, 就一直遍历
	 *  3. 当前节点指针cur不为空时, 将当前节点入栈, cur指向当前节点的左节点(如果有左节点,再下一次的时候左节点就能入栈了）
	 *  4. 当前节点指针cur为空时, 当栈的元素出栈, cur指向出栈元素的右节点(如果有右节点,再下一次的时候右节点就能入栈了)
	 *  		出栈的同时,判断和前一个节点的值差值是否小于minDiff
	 */
	public int getMinimumDifference(TreeNode root) {
		TreeNode pre = null;
		int minDiff = Integer.MAX_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.pop();
				if(pre != null) {
					minDiff = Math.min(minDiff, node.val - pre.val);
				}
				pre = node;
				cur = node.right;
			}
		}

		return minDiff;
	}
}
