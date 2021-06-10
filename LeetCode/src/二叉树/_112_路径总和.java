package 二叉树;

/**
 * @ClassName: 待分类._112_路径总和
 * @Author: whc
 * @Date: 2021/04/19/10:29
 */
public class _112_路径总和 {
	/*public boolean hasPathSum(TreeNode root, int targetSum) {
		return traversal(root, targetSum);
	}

	private boolean traversal(TreeNode root, int count) {
		if(root == null) {
			return false;
		}
		// 确定终止条件
		if(count - root.val == 0 && root.left == null && root.right == null) {
			return true;
		}

		// 单层递归逻辑
		boolean left = traversal(root.left, count-root.val);
		boolean right = traversal(root.right, count-root.val);
		return left || right;
	}*/


	/*public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		return traversal(root, targetSum - root.val);
	}

	private boolean traversal(TreeNode root, int count) {
		if(count == 0 && root.left == null && root.right == null) {
			return true;
		}
		if(root.left == null && root.right == null) {
			return false;
		}

		if(root.left != null) {
			count -= root.left.val;
			boolean left = traversal(root.left, count);
			if(left) {
				return true;
			}
			count += root.left.val;
		}

		if(root.right != null) {
			count -= root.right.val;
			boolean right = traversal(root.right, count);
			if(right) {
				return true;
			}
			count += root.right.val;
		}
		return false;
	}*/


	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null) {
			return targetSum == root.val;
		}
		boolean left = hasPathSum(root.left, targetSum - root.val);
		boolean right = hasPathSum(root.right, targetSum - root.val);
		return left || right;
	}

}
