package CodeTop;

/**
 * @ClassName: _572_另一棵树的子树
 * @Author: whc
 * @Date: 2021/09/09/22:35
 */
public class _572_另一棵树的子树 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		}

		if (t == null) {
			return true;
		}

		return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if(s == null && t == null) {
			return true;
		} else if(s == null || t == null) {
			return false;
		} else if(s.val != t.val) {
			return false;
		}

		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}