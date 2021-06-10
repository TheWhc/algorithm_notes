package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._46_全排列
 * @Author: whc
 * @Date: 2021/03/12/23:15
 */
public class _46_全排列 {
	/*public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(nums, res, path);
		return res;
	}

	private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
		}

		for (int i = 0; i < nums.length; i++) {
			// 剪枝
			if(path.contains(nums[i])) {
				continue;
			}
			path.add(nums[i]);
			dfs(nums, res, path);
			// 撤销选择
			path.remove(path.size()-1);
		}
	}*/

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, nums);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(path.contains(nums[i]))
				continue;
			path.add(nums[i]);
			backtrack(path, nums);
			path.remove(path.size()-1);
		}

	}
}
