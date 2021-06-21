package 二叉树.二叉树的属性;

import java.util.Stack;

/**
 * @ClassName: _404_左叶子之和
 * @Author: whc
 * @Date: 2021/06/21/16:08
 */
public class _404_左叶子之和 {

	/**
	 *  思路: 递归法
	 *
	 *  1. 确定递归函数返回值和参数的含义
	 *  int sumOfLeftLeaves(TreeNode root)
	 *
	 *  返回值为int
	 *  参数为当前节点
	 *
	 *  2. 确定终止条件
	 *  if(root == null) return 0;
	 *
	 *  3. 单层递归逻辑
	 *
	 *  遇到左节点的时候,记录数值,然后通过递归求取左子树和右子树 的左叶子之和
	 *
	 *  如何判断左节点?
	 *  通过父节点进行判断,若父节点的左节点不为空,且左节点的左右节点都为空,则说明是左叶子节点
	 */
	/*public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int midVal = 0;
		if(root.left != null && root.left.left == null && root.left.right == null) {
			midVal = root.left.val;
		}

		// 根 左 右 的遍历顺序
		return midVal + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}*/

	/**
	 *  思路: 迭代法
	 *  前序遍历的递归 也能 通过栈的迭代法实现
	 *
	 *  1. 当遇到左叶子节点的时候就进行累加
	 *  2. 判断左叶子节点的思路还是一样
	 *  3. 通过栈的迭代, 出栈, 然后将出栈元素的右节点和左节点不为空的入栈
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		int res = 0;

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left != null && node.left.left == null && node.left.right == null) {
				res += node.left.val;
			}
			if(node.right != null) {
				stack.push(node.right);
			}

			if(node.left != null) {
				stack.push(node.left);
			}
		}

		return res;

	}
}
