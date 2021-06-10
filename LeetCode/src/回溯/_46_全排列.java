package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._46_全排列
 * @Author: whc
 * @Date: 2021/04/30/10:59
 */
public class _46_全排列 {

	// 时间: O(n!)
	// 空间: O(n)
	/*List<List<Integer>> res = new ArrayList<>();
 	public List<List<Integer>> permute(int[] nums) {
		if(nums == null || nums.length == 0) return res;

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
			if(path.contains(nums[i])) continue;
			path.add(nums[i]);
			backtrack(path, nums);
			path.remove(path.size()-1);
		}
 	}*/

	// 优化
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		if(nums == null || nums.length == 0) return res;

		List<Integer> path = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtrack(path, nums, used);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums, boolean[] used) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(used[i] == true) continue;
			path.add(nums[i]);
			used[i] = true;
			backtrack(path, nums, used);
			used[i] = false;
			path.remove(path.size()-1);
		}
	}
}
