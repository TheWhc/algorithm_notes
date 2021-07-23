package CodeTop;

/**
 * @ClassName: _112_路径总和
 * @Author: whc
 * @Date: 2021/07/23/14:34
 */
public class _112_路径总和 {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		return dfs(root, targetSum);
	}

	private boolean dfs(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}

		targetSum -= root.val;

		if(root.left == null && root.right == null) {
			return targetSum == 0;
		}

		return dfs(root.left, targetSum) || dfs(root.right, targetSum);
	}
}
