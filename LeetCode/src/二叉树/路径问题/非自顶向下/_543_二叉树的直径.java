package 二叉树.路径问题.非自顶向下;

/**
 * @ClassName: _543_二叉树的直径
 * @Author: whc
 * @Date: 2021/07/23/11:27
 */
public class _543_二叉树的直径 {

	int res = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		dfs(root);
		return res;
	}

	// 返回当前节点的最长路径
	private int dfs(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);

		// 找出每一个节点的 左子树最大深度 + 右子树最大深度 的值，然后不断更新全局变量 res 即可。
		res = Math.max(res, left + right);

		// 返回必须包含当前节点的最长路径
		return Math.max(left, right) + 1;
	}
}
