package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _47_全排列II
 * @Author: whc
 * @Date: 2021/08/21/22:53
 */
public class _47_全排列II {

	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(nums, used);
		return res;
	}

	private void backtrack(int[] nums, boolean[] used) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// 同层重复元素
			if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
				continue;
			}

			// 同层未被使用过的元素
			if(!used[i]) {
				used[i] = true;
				path.add(nums[i]);
				backtrack(nums, used);
				path.remove(path.size() - 1);
				used[i] = false;
			}
		}
	}
}
