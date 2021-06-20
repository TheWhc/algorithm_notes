package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _145_二叉树的后序遍历
 * @Author: whc
 * @Date: 2021/06/20/13:13
 */
public class _145_二叉树的后序遍历 {

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
	 * 		递归右子树
	 * 		添加当前节点的元素
	 */
	/*List<Integer> res = new ArrayList<>();

	public List<Integer> postorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.left); // 左
		dfs(root.right); // 右
		res.add(root.val); // 根
	}*/


	/**
	 *  思路: 迭代法
	 *  用栈进行迭代
	 *
	 *  因为前序遍历是: 根左右
	 *  而后序遍历是: 左右根
	 *  很明显 将前序遍历先调整一下遍历顺序为: 根右左, 然后进行反转, 就变成了左右根了, 所以按照前序遍历的方式进行迭代
	 *
	 *  1. 将栈的元素出栈添加到结果集中(访问顺序和要处理的顺序一样)
	 *  2. 出栈的元素如果存在左节点,则添加到栈中
	 *  3. 出栈的元素如果存在右节点,则添加到栈中
	 *  4. 对结果集进行反转
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right != null) {
				stack.push(node.right);
			}
		}

		Collections.reverse(res);

		return res;
	}
}
