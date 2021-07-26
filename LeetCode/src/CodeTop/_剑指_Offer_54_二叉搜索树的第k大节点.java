package CodeTop;

/**
 * @ClassName: _剑指_Offer_54_二叉搜索树的第k大节点
 * @Author: whc
 * @Date: 2021/07/26/15:45
 */
public class _剑指_Offer_54_二叉搜索树的第k大节点 {

	// 中序遍历
	int k;
	int res;
	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}

		dfs(root.right);
		k--;
		if(k == 0) {
			res = root.val;
			return;
		}
		dfs(root.left);
	}
}
