package 二叉树.二叉树的属性;

/**
 * @ClassName: _100_相同的树
 * @Author: whc
 * @Date: 2021/06/21/15:57
 */
public class _100_相同的树 {

	/**
	 *  思路: 递归法
	 *  与对称二叉树类似的思想
	 *  1. 如果左右都空为,返回true
	 *  2. 如果左右其中一个为空,则返回false
	 *  3. 如果左右都不为空,但是值不相同,返回false
	 *  	(如果值相同,那就进入递归继续判断子树是否相同)
	 *  4. 递归判断p节点的左节点和q节点的左节点, p节点的右节点和q节点的右节点
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		} else if(p == null || q == null) {
			return false;
		} else if(p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
