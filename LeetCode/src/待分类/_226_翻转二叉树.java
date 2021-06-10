package 待分类;

/**
 * @ClassName: 待分类._226_翻转二叉树
 * @Author: whc
 * @Date: 2021/03/22/11:32
 */
public class _226_翻转二叉树 {

	/*public TreeNode invertTree(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}*/

	// 前序遍历 根左右
	/*public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		// 交换节点
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		// 翻转左子树
		invertTree(root.left);
		// 翻转右子树
		invertTree(root.right);
		return root;
	}*/

	// 后序遍历 左右根
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		invertTree(root.left);
		invertTree(root.right);
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		return root;
	}
}
