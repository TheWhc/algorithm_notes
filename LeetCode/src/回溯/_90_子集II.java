package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _90_子集II
 * @Author: whc
 * @Date: 2021/04/30/9:15
 */
public class _90_子集II {

	// 时间复杂度: O(n * 2^n) 每一个元素所以2^n, 每一组子集都要数组,需要n
	// 空间复杂度: O(n)
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums == null || nums.length == 0) return res;

		List<Integer> path = new ArrayList<>();
		boolean[] ans = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(path, nums, 0, ans);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums, int startIndex, boolean[] ans) {
		res.add(new ArrayList<>(path));
		if(startIndex >= nums.length) {
			return;
		}

		// ans[i-1] == false 说明同一树层candidates[i-1]使用过
		// ans[i-1] == true 说明同一树枝candidates[i-1]使用过
		for (int i = startIndex; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i-1] && ans[i-1] == false) {
				continue;
			}
			path.add(nums[i]);
			ans[i] = true;
			backtrack(path, nums, i+1, ans);
			ans[i] = false;
			path.remove(path.size()-1);
		}
	}

}
