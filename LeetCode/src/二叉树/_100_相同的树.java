package 二叉树;

/**
 * @ClassName: _100_相同的树
 * @Author: whc
 * @Date: 2021/04/18/11:15
 */
public class _100_相同的树 {

	/*public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q != null) {
			return false;
		} else if(p != null && q == null) {
			return false;
		} else if(p == null && q == null) {
			return true;
		} else if(p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}*/

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return compare(p, q);
	}

	private boolean compare(TreeNode p, TreeNode q) {
		if(p == null && q != null) {
			return false;
		} else if(p != null && q == null) {
			return false;
		} else if(p == null && q == null) {
			return true;
		} else if(p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
