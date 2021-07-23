package 二叉树.路径问题.自顶向下;

/**
 * @ClassName: _112_路径总和
 * @Author: whc
 * @Date: 2021/07/23/14:25
 */
public class _112_路径总和 {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		return dfs(root, targetSum);
	}

	private boolean dfs(TreeNode root, int targetSum) {
		if(root == null) {
			return true;
		}

		targetSum -= root.val;

		if(root.left == null && root.right == null && targetSum == 0) {
			return true;
		}

		dfs(root.left, targetSum);
		dfs(root.right, targetSum);

		return false;
	}
}
