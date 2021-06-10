package 剑指offer;

/**
 * @ClassName: _剑指_Offer_33_二叉搜索树的后序遍历序列
 * @Author: whc
 * @Date: 2021/05/29/11:05
 */
public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {

	/**
	 *  思路: 二叉搜索树的定义,左子树值都小于根节点,右子树值都大于根节点
	 *  1. 设置k计数项,用于记录后序遍历序列中左子树的选取范围,以此划分左右子树
	 *  2. postorder[k] > postorder[r],此时k为左子树数量,左子树范围是[l,k-1],右子树范围是[k,r-1]
	 *  3. 判断右子树的值是否都大于postorder[r]根节点的值,不是则返回false
	 *  4. 递归传入左子树和右子树,设置终止条件(当l >= r,则返回true)
	 */
	public boolean verifyPostorder(int[] postorder) {
		if(postorder == null || postorder.length == 0) {
			return false;
		}
		return dfs(0, postorder.length-1, postorder);
	}

	private boolean dfs(int l, int r, int[] postorder) {
		// 递归终止条件
		if(l >= r) {
			return true;
		}
		// 根节点的值
		int root = postorder[r];
		// 左子树起点下标
		int k = l;
		// 找到左子树节点的范围
		while(k < r && postorder[k] < root) {
			k++;
		}
		// 右子树起点,判断是否都大于根节点,否则直接返回false
		for (int i = k; i < r; i++) {
			if(postorder[i] < root) {
				return false;
			}
		}

		// 递归判断左子树和右子树是否满足
		return dfs(l, k-1, postorder) && dfs(k, r-1, postorder);
	}

}
