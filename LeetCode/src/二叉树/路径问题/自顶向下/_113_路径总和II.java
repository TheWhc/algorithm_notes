package 二叉树.路径问题.自顶向下;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _113_路径总和II
 * @Author: whc
 * @Date: 2021/07/23/14:25
 */
public class _113_路径总和II {

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		dfs(root, targetSum, new ArrayList<>());
		return res;
	}

	private void dfs(TreeNode root, int sum, ArrayList<Integer> path) {
		if(root == null) {
			return;
		}

		// 做出选择
		path.add(root.val);

		// 到达叶子节点
		if(root.left == null && root.right == null) {
			if(sum - root.val == 0) {
				res.add(new ArrayList<>(path));
			}
			path.remove(path.size()-1);
			return;
		}

		dfs(root.left, sum - root.val, path);
		dfs(root.right, sum - root.val, path);
		path.remove(path.size()-1);
	}
}
