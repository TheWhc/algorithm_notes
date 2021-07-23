package 二叉树.路径问题.自顶向下;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _面试题_04_12_求和路径
 * @Author: whc
 * @Date: 2021/07/23/13:24
 */
public class _面试题_04_12_求和路径 {

	int res = 0;
	public int pathSum(TreeNode root, int sum) {
		if(root == null) {
			return res;
		}
		// 以根节点为路径的起点
		dfs(root, sum);
		// 以左节点为路径的起点
		pathSum(root.left, sum);
		// 以右节点为路径的起点
		pathSum(root.right, sum);
		return res;
	}

	private void dfs(TreeNode root, int sum) {
		if(root == null) {
			return;
		}

		sum -= root.val;

		if(sum == 0) {
			res++;
		}

		dfs(root.left, sum);
		dfs(root.right, sum);
	}

}
