package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _46_全排列
 * @Author: whc
 * @Date: 2021/07/20/15:02
 */
public class _46_全排列 {

	/*List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		backtrack(nums, new ArrayList<>());
		return res;
	}

	private void backtrack(int[] nums, List<Integer> path) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(path.contains(nums[i])) {
				continue;
			}
			path.add(nums[i]);
			backtrack(nums, path);
			path.remove(path.size()-1);
		}
	}*/


	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
		return res;
	}

	private void backtrack(int[] nums, List<Integer> path, boolean[] used) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(!used[i]) {
				used[i] = true;
				path.add(nums[i]);
				backtrack(nums, path, used);
				path.remove(path.size() - 1);
				used[i] = false;
			}
		}
	}
}
