package CodeTop;

/**
 * 后序遍历：一层一层向上传递；
 * 无后效性：把不确定的因素固定下来，以便分类讨论
 *
 * @ClassName: _124_二叉树中的最大路径和
 * @Author: whc
 * @Date: 2021/07/23/9:46
 */
public class _124_二叉树中的最大路径和 {

	/**
	 * 思路：
	 * 1. 状态定义
	 * 我们规定必须经过子树的根结点，并且最大路径的和表示的路径只来自左子树和右子树 其中之一 的 最大值。也就是说，这条「路径」其实只走一边。
	 *
	 * 2. 后序遍历
	 * 先得两个子问题的解,再根据两个子问题的解得到当前规模更大的子问题的结果
	 *
	 * 3. 题目问的结果在求解子问题的过程中得到
	 * 我们对状态的定义规定了只来自左右子树的一边，在后序遍历的时候，左右子树的结果都求得的情况下，
	 * 当前结点就可以把左右两棵子树的求解结果进行综合，就是题目要求的 经过某个结点 的最大路径和。
	 *
	 */
	/*int res = Integer.MIN_VALUE; // 定义一个全局变量
	public int maxPathSum(TreeNode root) {
		dfs(root);
		return res;
	}

	*//**
	 * 规定 node 必须被选取
	 *
	 * @param node
	 * @return 返回必须经过 node 的直的路径的最大和，这条路径到 node 为止，即：这条路径在左子树和右子树的路径中只能选择一条
	 *//*

	private int dfs(TreeNode node) {
		if(node == null) {
			return 0;
		}

		// 这里体现了「后序遍历」，先递归求解左、右子树
		// 由于结点的值有可能为负数，因此如果子树得到的路径是负数，可以舍弃，表现为和 0 取最大值
		int leftSum = Math.max(dfs(node.left), 0);
		int rightSum = Math.max(dfs(node.right), 0);

		// node.val 必须被选择体现在这里
		// 在深度优先遍历的过程中选出最大值
		res = Math.max(res, node.val + leftSum + rightSum);

		// 返回左右子树较长的路径加上根节点值
		return Math.max(leftSum, rightSum) + node.val;
	}*/


	/**
	 * 思路：全部变量 + 递归
	 *
	 * 1. 求左子树和右子树能返回的最大值,选一个较大的
	 * 2. 在递归的过程中考虑包含当前根节点的最大路径(更新maxRes的值)
	 * 3. 在最后只返回包含当前根节点和左子树或者右子树的路径
	 *
	 * https://leetcode.wang/leetcode-124-Binary-Tree-Maximum-Path-Sum.html
	 */
	int maxRes = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		helper(root);
		return maxRes;
	}

	private int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);

		// 过程中更新maxRes的值
		maxRes = Math.max(maxRes, root.val + left + right);

		// 最后返回包含当前根节点和左子树或者右子树的路径
		// (不能同时返回当前节点和左子树和右子树,因为同时选择了的话,就无法通过上一层根节点的路径
		return Math.max(left, right) + root.val;
	}
}
