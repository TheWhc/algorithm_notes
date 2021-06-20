package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _144_二叉树的前序遍历
 * @Author: whc
 * @Date: 2021/06/20/13:05
 */
public class _144_二叉树的前序遍历 {

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
	 * 		添加当前节点的元素
	 * 		递归左子树
	 * 		递归右子树
	 */
	/*List<Integer> res = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		res.add(root.val); // 根
		dfs(root.left); // 左
		dfs(root.right); // 右
	}*/

	/**
	 *  思路: 迭代法
	 *
	 *  用栈进行迭代
	 *  由于访问元素和要处理元素的顺序是一致的,所以不需要借助指针
	 *
	 *  1. 将栈的元素出栈添加到结果集中
	 *  2. 出栈的元素如果存在右节点,则添加到栈中
	 *  3. 出栈的元素如果存在左节点,则添加到栈中
	 *
	 *  例子: 前序遍历的结果为 {1,4,5,3,2}
	 *         1
	 *       /  \
	 *      4   2
	 *     /\
	 *    5 3
	 *
	 * ①
	 *    ---------------
	 *    | 1
	 *    ---------------
	 * 结果集[]
	 *
	 * ②
	 *   ---------------
	 * 	 | 2 4
	 * 	 ---------------
	 * 结果集[1]
	 *
	 * ③
	 *   ---------------
	 * 	 | 2 3 5
	 * 	 ---------------
	 * 结果集{1,4}
	 *
	 * ④
	 *   ---------------
	 * 	 |
	 * 	 ---------------
	 * 	结果集{1,4,5,3,2}
	 *
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
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
