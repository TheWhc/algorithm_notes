package CodeTop;

/**
 * @ClassName: _剑指_Offer_33_二叉搜索树的后序遍历序列
 * @Author: whc
 * @Date: 2021/09/11/22:50
 */
public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {

	public boolean verifyPostorder(int[] postorder) {
		if(postorder == null || postorder.length == 0) {
			return true;
		}

		return dfs(0, postorder.length-1, postorder);
	}

	private boolean dfs(int left, int right, int[] postorder) {
		if(left >= right) {
			return true;
		}

		int k = left;
		int rootVal = postorder[right];
		while(k < right && postorder[k] < rootVal) {
			k++;
		}

		for (int i = k; i < right; i++) {
			if(postorder[i] < rootVal) {
				return false;
			}
		}

		// 递归判断左子树和右子树
		return dfs(left, k-1, postorder) && dfs(k, right-1, postorder);
	}
}
