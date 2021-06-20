package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.List;

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
	List<Integer> res = new ArrayList<>();

	public List<Integer> postorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.left); // 左
		dfs(root.right); // 右
		res.add(root.val); // 根
	}
}
