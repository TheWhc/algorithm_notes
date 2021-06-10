package 回溯;

import java.util.*;

/**
 * @ClassName: _491_递增子序列
 * @Author: whc
 * @Date: 2021/04/30/9:58
 */
public class _491_递增子序列 {

	/*List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums == null || nums.length == 0) {
			return res;
		}
		List<Integer> path = new ArrayList<>();
		backtrack(path, nums, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums, int startIndex) {

		if(path.size() >= 2) {
			res.add(new ArrayList<>(path));
		}
		Set<Integer> set = new HashSet<>(); // 记录本层使用过的元素
		for (int i = startIndex; i < nums.length; i++) {
			// 去重
			if((!path.isEmpty() && nums[i] < path.get(path.size()-1)) || set.contains(nums[i])) {
				continue;
			}
			path.add(nums[i]);
			set.add(nums[i]);
			backtrack(path, nums, i+1);
			path.remove(path.size()-1);
		}
	}*/

	// 优化
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums == null || nums.length == 0) {
			return res;
		}
		List<Integer> path = new ArrayList<>();
		backtrack(path, nums, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums, int startIndex) {

		if(path.size() >= 2) {
			res.add(new ArrayList<>(path));
		}
		int[] used = new int[201]; // 数值范围在-100~100之间
		for (int i = startIndex; i < nums.length; i++) {
			// 去重
			if((!path.isEmpty() && nums[i] < path.get(path.size()-1)) || used[nums[i] + 100] == 1) {
				continue;
			}
			path.add(nums[i]);
			used[nums[i] + 100] = 1;
			backtrack(path, nums, i+1);
			path.remove(path.size()-1);
		}
	}

}
