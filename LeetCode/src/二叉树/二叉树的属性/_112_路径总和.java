package 二叉树.二叉树的属性;

/**
 * @ClassName: _112_路径总和
 * @Author: whc
 * @Date: 2021/06/21/18:00
 */
public class _112_路径总和 {

	/**
	 *  思路: 递归法
	 *  1. 确定递归函数返回值和参数类型
	 *  	boolean hasPathSum(TreeNode root, int targetSum)
	 *  	因为只需要搜索到一条满足的路径即可立即返回,所以返回值为boolean
	 *
	 *  2. 确定终止条件
	 *  	遇到空节点的时候直接返回false
	 *
	 *  3. 单层递归逻辑
	 *
	 */
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}

		// 单层递归逻辑
		// 遇到叶子节点并且目标值计数为0,返回true
		// 遇到叶子节点但是计数不为0, 返回false
		if(root.left == null && root.right == null) {
			return targetSum - root.val == 0;
		}

		// 左子树不为空的时候,递归左子树
		if(root.left != null) {
			// 包含回溯的逻辑
			boolean left = hasPathSum(root.left, targetSum - root.val);
			if(left) {
				return true;
			}
		}

		// 右子树不为空的时候,递归右子树
		if(root.right != null) {
			// 包含回溯的逻辑
			boolean right = hasPathSum(root.right, targetSum - root.val);
			if(right) {
				return true;
			}
		}

		return false;
	}

	// 简洁写法
	/*public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}

		// 单层递归逻辑
		// 遇到叶子节点并且目标值计数为0,返回true
		// 遇到叶子节点但是计数不为0, 返回false
		if(root.left == null && root.right == null) {
			return targetSum - root.val == 0;
		}

		return hasPathSum(root.left, targetSum - root.val) ||
				hasPathSum(root.right, targetSum - root.val);
	}*/

}
