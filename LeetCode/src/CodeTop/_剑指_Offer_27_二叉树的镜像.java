package CodeTop;

/**
 * @ClassName: _剑指_Offer_27_二叉树的镜像
 * @Author: whc
 * @Date: 2021/08/19/8:54
 */
public class _剑指_Offer_27_二叉树的镜像 {

	// 递归法
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null) {
			return null;
		}

		TreeNode left = mirrorTree(root.left);
		TreeNode right = mirrorTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
}
