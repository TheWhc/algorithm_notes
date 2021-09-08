package CodeTop;

/**
 * @ClassName: _100_相同的树
 * @Author: whc
 * @Date: 2021/09/05/17:39
 */
public class _100_相同的树 {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		}

		if(p == null || q == null || p.val != q.val) {
			return false;
		}

		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);

		return left && right;
	}
}
