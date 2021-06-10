package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._113_路径总和II
 * @Author: whc
 * @Date: 2021/03/08/10:26
 */
public class _113_路径总和II {


	/*public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		if(root == null) {
			return res;
		}
		return findPath(root, res, path, targetSum);
	}

	private List<List<Integer>>  findPath(TreeNode root,List<List<Integer>> res, List<Integer> path, int targetSum) {
		targetSum -= root.val;
		path.add(root.val);
		if(targetSum == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<>(path));
			return res;
		}

		if(root.left != null) {
			findPath(root.left, res, path, targetSum);
			path.remove(path.size()-1);
		}

		if(root.right != null) {
			findPath(root.right, res, path, targetSum);
			path.remove(path.size()-1);
		}

		return res;
	}*/

	// 2021/3/15 二刷
//	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//		List<List<Integer>> res = new ArrayList<>();
//		List<Integer> path = new ArrayList<>();
//		if(root == null) return res;
//		path.add(root.val);
//		traverse(res, path, root, targetSum - root.val);
//		return res;
//	}
//
//	private void traverse(List<List<Integer>> res, List<Integer> path, TreeNode cur, int count) {
//		// 叶子节点且和为sum的路径
//		if(cur.left == null && cur.right == null && count == 0) {
//			res.add(new ArrayList<>(path));
//			return;
//		}
//
//		// 叶子节点且和不满足sum
//		if(cur.left == null && cur.right == null)
//			return;
//
//		if(cur.left != null) {
//			path.add(cur.left.val);
//			traverse(res, path, cur.left, count - cur.left.val);
//			path.remove(path.size()-1);
//		}
//
//		if(cur.right != null) {
//			path.add(cur.right.val);
//			traverse(res, path, cur.right, count - cur.right.val);
//			path.remove(path.size()-1);
//		}
//	}

	List<List<Integer>> res = new ArrayList<>();
	// 2021/4/1 三刷
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<Integer> path = new ArrayList<>();
		if(root == null)
			return res;
		int sum = root.val;
		path.add(root.val);
		backtrack(path, root, sum, targetSum);
		return res;
	}

	private void backtrack(List<Integer> path, TreeNode root, int sum, int targetSum) {
		// 递归终止条件
		if(sum == targetSum && root.left == null && root.right == null) {
			res.add(new ArrayList<>(path));
			return;
		}

		if(root.left == null && root.right == null)
			return;

		if(root.left != null) {
			path.add(root.left.val);
			sum += root.left.val;
			backtrack(path, root.left, sum, targetSum);
			sum -= root.left.val;
			path.remove(path.size()-1);
		}

		if(root.right != null) {
			path.add(root.right.val);
			sum += root.right.val;
			backtrack(path, root.right, sum, targetSum);
			sum -= root.right.val;
			path.remove(path.size()-1);
		}
	}
}
