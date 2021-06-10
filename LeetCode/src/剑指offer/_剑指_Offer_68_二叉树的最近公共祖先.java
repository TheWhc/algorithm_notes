package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_68_二叉树的最近公共祖先
 * @Author: whc
 * @Date: 2021/04/02/1:39
 */
public class _剑指_Offer_68_二叉树的最近公共祖先 {

	/**
	 *  思路: (求最小公共祖先问题) 递归回溯法
	 *  1. 从底向上遍历,二叉树只能通过后序遍历实现
	 *  2. 回溯过程中,需要遍历整颗二叉树,即使已经找到结果了,依然要把其它节点遍历完,因为要使用递归函数的返回值做逻辑判断
	 *  （递归函数什么时候需要返回值？
	 *  遍历整颗二叉树,不需要返回值,如果要搜索其中一条符合条件的路径,递归函数需要返回值,因为遇到了
	 *  符合条件的路径了就需要及时返回, 有了返回值还要做进一步处理。）
	 *
	 *  对于本题来说，需要在回溯的过程中递归函数的返回值做判断路径符不符合,所以需要返回值,而且要遍历整颗二叉树,因为left和right后序还要做逻辑处理
	 *
	 *  3. 左为空,右不为空,则返回右节点
	 *     左不为空,右为空,则返回左节点
	 *     左不为空,右不为空,则返回根节点
	 *     左为空,右为空,则返回空节点
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null) {
			return root;
		}
		if(left == null && right != null) {
			return right;
		}
		if(right == null && left != null) {
			return left;
		}
		return root;
	}

}
