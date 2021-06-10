package 待分类;

/**
 * @ClassName: 待分类._543_二叉树的直径
 * @Author: whc
 * @Date: 2021/03/19/14:58
 */
public class _543_二叉树的直径 {

	int maxLength = 0;
	// 转化为每个节点的左右子树的和
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		getDepth(root);
		return maxLength;
	}

	private int getDepth(TreeNode node) {
		if(node == null)
			return 0;
		int leftDepth = getDepth(node.left);
		int rightDepth = getDepth(node.right);
		int curDepth = Math.max(leftDepth, rightDepth) + 1;
		maxLength = Math.max(curDepth, maxLength);
		return curDepth;
	}
}
