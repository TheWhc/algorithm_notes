package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_54_二叉搜索树的第k大节点
 * @Author: whc
 * @Date: 2021/04/02/0:19
 */
public class _剑指_Offer_54_二叉搜索树的第k大节点 {

	/**
	 * 思路: 中序遍历
	 *
	 * 右根左遍历
	 */
	int k = 0;
	int res = Integer.MIN_VALUE;
	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) return;

		dfs(root.right);
		k--;
		if(k == 0) {
			res = root.val;
		}
		dfs(root.left);
	}
}
