package 二叉树.路径问题.非自顶向下;

/**
 * @ClassName: _337_打家劫舍III
 * @Author: whc
 * @Date: 2021/07/23/11:48
 */
public class _337_打家劫舍III {

	// 节点的状态: dp[node][j]:表示一个节点,规定node节点是否能够获得的最大价值
	public int rob(TreeNode root) {
		int[] res = dfs(root);

		// res[0]表示不偷当前节点的最大价值,res[1]表示偷当前节点的最大价值
		return Math.max(res[0], res[1]);
	}

	private int[] dfs(TreeNode root) {
		if(root == null) {
			return new int[]{0, 0};
		}

		// 左节点状态
		int[] left = dfs(root.left);
		// 右节点状态
		int[] right = dfs(root.right);

		// 当前节点的状态
		int[] dp = new int[2];

		// 不偷当前节点
		dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		// 偷当前节点
		dp[1] = root.val + left[0] + right[0];

		return dp;
	}
}
