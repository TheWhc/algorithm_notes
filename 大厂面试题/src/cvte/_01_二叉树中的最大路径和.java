package cvte;

/**
 * @ClassName: _01_二叉树中的最大路径和
 * @Author: whc
 * @Date: 2021/10/01/8:50
 */
public class _01_二叉树中的最大路径和 {

	int maxValue = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		dfs(root);
		return maxValue;
	}

	private int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = Math.max(dfs(root.left), 0);
		int right = Math.max(dfs(root.right), 0);

		// 更新包含当前根节点,maxValue可能的最大值
		maxValue = Math.max(maxValue, root.val + left + right);

		return Math.max(left, right) + root.val;
	}
}
