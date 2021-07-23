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
	int res = Integer.MIN_VALUE; // 定义一个全局变量
	public int maxPathSum(TreeNode root) {
		dfs(root);
		return res;
	}

	/**
	 * 规定 node 必须被选取
	 *
	 * @param node
	 * @return 返回必须经过 node 的直的路径的最大和，这条路径到 node 为止，即：这条路径在左子树和右子树的路径中只能选择一条
	 */

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
	}
}
