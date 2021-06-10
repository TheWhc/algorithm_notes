package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: 待分类._113_路径总和II
 * @Author: whc
 * @Date: 2021/04/19/11:50
 */
public class _113_路径总和II {

	List<List<Integer>> res = new ArrayList<>();

	// 回溯, 往下减
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return res;
		}
		List<Integer> path = new LinkedList<>();
		backtrack(root, path, targetSum);
		return res;
	}

	private void backtrack(TreeNode root, List<Integer> path, int count) {
		if(root == null) {
			return;
		}

		// 当前节点加入到路径中
		path.add(root.val);

		if(root.left == null && root.right == null) {
			// 叶子节点 并且 count = 0 时,将路径添加到结果
			if(count == root.val) {
				res.add(new ArrayList<>(path));
			}
			// 回溯撤销选择
			path.remove(path.size()-1);
			return;
		}

		// 做出选择
		backtrack(root.left, path, count-root.val);
		backtrack(root.right, path, count-root.val);
		// 回溯撤销选择
		path.remove(path.size()-1);
	}
}
