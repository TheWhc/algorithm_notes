package 待分类;

/**
 * @ClassName: 待分类._124_二叉树中的最大路径和
 * @Author: whc
 * @Date: 2021/03/14/14:39
 */
public class _124_二叉树中的最大路径和 {
	int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		dfs(root);
		return res;
	}

	private int dfs(TreeNode root) {
		if(root == null)
			return 0;

		//计算左边分支最大值，左边分支如果为负数还不如不选择
		int leftMax = Math.max(0, dfs(root.left));
		//计算右边分支最大值，右边分支如果为负数还不如不选择
		int rightMax = Math.max(0, dfs(root.right));
		//left->root->right 作为路径与已经计算过历史最大值做比较
		res = Math.max(res, root.val + leftMax + rightMax);
		// 返回当前节点的总贡献,返回经过root的单边最大分支给当前root的父节点计算使用
		return root.val + Math.max(leftMax, rightMax);
	}
}
