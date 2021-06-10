package 二叉树;

/**
 * @ClassName: _572_另一个树的子树
 * @Author: whc
 * @Date: 2021/04/18/11:19
 */
public class _572_另一个树的子树 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) {
			return false;
		}
		if(t == null) {
			return true;
		}
		return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if(s == null && t != null) {
			return false;
		} else if(s != null && t == null) {
			return false;
		} else if(s == null && t == null) {
			return true;
		} else if(s.val != t.val) {
			return false;
		}

		// 单层递归逻辑
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
