package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._112_路径总和
 * @Author: whc
 * @Date: 2021/03/08/11:34
 */
public class _112_路径总和 {
	/*public boolean hasPathSum(TreeNode root, int targetSum) {
		return findPath(root, targetSum);
	}

	private boolean findPath(TreeNode root, int targetSum) {
		if(root == null)
			return false;
		targetSum -= root.val;
		if(targetSum == 0 && root.left == null && root.right == null) {
			return true;
		}

		return findPath(root.left, targetSum) || findPath(root.right, targetSum);
	}*/

	// 2021/3/15 二刷
	// 使用深度优先遍历方式(前中后序都可以) 回溯法
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null)
			return false;
		return traverse(root, targetSum - root.val);
	}

	private boolean traverse(TreeNode cur, int count) {
		// 叶子节点,并且计数器为0 返回true
		if(cur.left == null && cur.right == null && count == 0)
			return true;
		// 叶子节点直接返回
		if(cur.left == null && cur.right == null)
			return false;

		if(cur.left != null) {
			count -= cur.left.val; // 递归,处理节点
			// 递归函数是有返回值的，如果递归函数返回true，说明找到了合适的路径，应该立刻返回。
			if(traverse(cur.left, count)) return true;
			count += cur.left.val; // 回溯,撤销处理结果
		}

		if(cur.right != null) {
			count -= cur.right.val; // 递归,处理节点
			// 递归函数是有返回值的，如果递归函数返回true，说明找到了合适的路径，应该立刻返回。
			if(traverse(cur.right, count)) return true;
			count += cur.right.val; // 回溯,撤销处理结果
		}

		return false;
	}
}
