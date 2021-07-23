package CodeTop;

/**
 * @ClassName: _687_最长同值路径
 * @Author: whc
 * @Date: 2021/07/23/11:13
 */
public class _687_最长同值路径 {

	int res = 0;
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return res;
	}

	// 返回以node节点为起点的最长同值路径
	private int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = dfs(node.left); // node左子树的最长同值路径
		int right = dfs(node.right); // node右子树的最长同值路径

		// node节点与左节点相同
		if (node.left != null && node.val == node.left.val) {
			left++;
		} else {
			left = 0;
		}
		if (node.right != null && node.val == node.right.val) {
			right++;
		} else {
			right = 0;
		}

		res = Math.max(res, left + right);

		// 返回左右节点中最长同值路径
		return Math.max(left, right);
	}
}
