package 待分类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._47_全排列II
 * @Author: whc
 * @Date: 2021/03/13/0:26
 */
public class _47_全排列II {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		// 排序（升序或者降序都可以），排序是剪枝的前提
		Arrays.sort(nums);
		dfs(nums, res, path, used);
		return res;
	}

	private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// 这个数已被使用过,跳过
			if(used[i])
				continue;

			// 避免产生重复的列 针对同一层
			// used[i - 1] == true，说明同一树支nums[i - 1]使用过
			// used[i - 1] == false，说明同一树层nums[i - 1]使用过
			// 如果同一树层nums[i - 1]使用过则直接跳过
			if(i > 0 && nums[i-1] == nums[i]  && !used[i-1]) {
				continue;
			}

			path.add(nums[i]);
			used[i] = true;
			dfs(nums, res, path, used);
			used[i] = false;
			path.remove(path.size()-1);
		}
	}

	public static void main(String[] args) {
		permuteUnique(new int[]{1,1,2});
	}
}
