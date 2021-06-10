package 待分类;

/**
 * @ClassName: 待分类._235_二叉搜索树的最近公共祖先
 * @Author: whc
 * @Date: 2021/03/15/17:38
 */
public class _235_二叉搜索树的最近公共祖先 {

	// 二叉搜索树自带方向性，可以方便的从上向下查找目标区间，遇到目标区间内的节点，直接返回。
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
}
