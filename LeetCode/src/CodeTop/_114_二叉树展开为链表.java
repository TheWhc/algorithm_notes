package CodeTop;

/**
 * @ClassName: _114_二叉树展开为链表
 * @Author: whc
 * @Date: 2021/09/02/15:22
 */
public class _114_二叉树展开为链表 {

	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);
		TreeNode rightTree = root.right;
		root.right = root.left;
		root.left = null;
		while(root.right != null) {
			root = root.right;
		}
		root.right = rightTree;
	}
}
