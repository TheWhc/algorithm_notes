package CodeTop;

/**
 * @ClassName: _230_二叉搜索树中第K小的元素
 * @Author: whc
 * @Date: 2021/08/20/14:32
 */
public class _230_二叉搜索树中第K小的元素 {

	// 中序遍历 左根右
	int k;
	int res;
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}

		dfs(root.left);
		k--;
		if(k == 0) {
			res = root.val;
			return;
		}
		dfs(root.right);
	}
}
