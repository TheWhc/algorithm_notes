package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _剑指_Offer_34_二叉树中和为某一值的路径
 * @Author: whc
 * @Date: 2021/09/11/23:29
 */
public class _剑指_Offer_34_二叉树中和为某一值的路径 {

	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		if(root == null) {
			return res;
		}

		dfs(root, target);
		return res;
	}

	private void dfs(TreeNode root, int target) {
		if(root == null) {
			return;
		}

		path.add(root.val);
		target -= root.val;
		if(root.left == null && root.right == null && target == 0) {
			res.add(new ArrayList<>(path));
		}
		dfs(root.left, target);
		dfs(root.right, target);
		path.remove(path.size()-1);
	}
}
