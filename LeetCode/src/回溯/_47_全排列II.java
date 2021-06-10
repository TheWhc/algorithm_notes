package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._47_全排列II
 * @Author: whc
 * @Date: 2021/04/30/11:34
 */
public class _47_全排列II {

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		if(nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
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
			// used[i-1] = false 表示同一树层已经使用过
			// used[i-1] = true 表示同一树枝已使用过
			if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false) {
				continue;
			}
			if(used[i] == false) {
				path.add(nums[i]);
				used[i] = true;
				backtrack(path, nums, used);
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}

}
