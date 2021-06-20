package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _94_二叉树的中序遍历
 * @Author: whc
 * @Date: 2021/06/20/13:09
 */
public class _94_二叉树的中序遍历 {

	/**
	 * 思路: 递归法
	 *
	 * 1. 递归函数的返回值和参数:
	 * 		返回值为void,遍历整颗二叉树
	 * 		void dfs(TreeNode root): 参数为当前节点
	 *
	 * 2. 递归终止条件
	 * 		节点为空时,直接返回
	 *
	 * 3. 单层递归逻辑
	 * 		递归左子树
	 * 		添加当前节点的元素
	 * 		递归右子树
	 */
	/*List<Integer> res = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.left); // 左
		res.add(root.val); // 根
		dfs(root.right); // 右
	}*/

	/**
	 *  思路: 迭代法
	 *  栈 + 指针
	 *
	 *  因为中序遍历的时候, 访问的元素和要处理的元素顺序是不一致的, 一直要遍历到树左面的最底部,所以需要借用指针的遍历来帮助访问节点
	 *  再开始处理节点,而前序遍历由于访问元素和要处理元素的顺序是一致的,所以不需要借助指针
	 *
	 *  1. 栈不为空 或者 当前节点指针cur 不为空的时候, 就一直遍历
	 *  2. 当前节点指针cur不为空时, 将当前节点入栈, cur指向当前节点的左节点(如果有左节点,再下一次的时候左节点就能入栈了）
	 *  3. 当前节点指针cur为空时, 当栈的元素出栈, cur指向出栈元素的右节点(如果有右节点,再下一次的时候右节点就能入栈了)
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		// 一开始的时候,栈为空,但是当前节点指向了根节点不为空
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				// 不为空的时候,添加当前节点元素
				stack.push(cur);
				cur = cur.left;
			} else {
				// 为空的时候,出栈的元素
				TreeNode node = stack.pop();
				res.add(node.val);
				cur = node.right;
			}
		}

		return res;
	}
}
