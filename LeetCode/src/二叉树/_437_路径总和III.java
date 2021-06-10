package 二叉树;

/**
 * @ClassName: 待分类._437_路径总和III
 * @Author: whc
 * @Date: 2021/04/19/12:12
 */
public class _437_路径总和III {

	public int pathSum(TreeNode root, int sum) {
		if(root == null) {
			return 0;
		}
		// 从根节点开始向下找 或者 从其它非根节点开始向下找
		return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private int pathSumStartWithRoot(TreeNode root, int count) {
		if(root == null) {
			return 0;
		}
		// 以当前节点为起始节点让路径和先归0,重新开始向下找路径和是否与count匹配
		int result = 0;
		if(root.val == count) {
			result++;
		}
		// 探索当前节点向下所有左右子树
		result += pathSumStartWithRoot(root.left, count-root.val) + pathSumStartWithRoot(root.right, count-root.val);
		return result;
	}
}
