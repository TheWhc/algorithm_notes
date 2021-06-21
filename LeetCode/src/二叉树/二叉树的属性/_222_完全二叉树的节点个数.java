package 二叉树.二叉树的属性;

/**
 * @ClassName: _222_完全二叉树的节点个数
 * @Author: whc
 * @Date: 2021/06/21/11:31
 */
public class _222_完全二叉树的节点个数 {

	/**
	 *  思路: 递归法
	 *  返回左子树和右子树的节点数量 + 1
	 */
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}

		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}
