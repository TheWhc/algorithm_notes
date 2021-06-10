package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._78_子集
 * @Author: whc
 * @Date: 2021/03/23/16:38
 */
public class _78_子集 {

	/*List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, nums, 0);
		return res;
	}

	// 1. 递归函数参数
	*//**
	 *
	 * @param path 选择的路径
	 * @param nums 选择的列表
	 * @param startIndex 开始搜索的下标
	 *//*
	private void backtrack(List<Integer> path, int[] nums, int startIndex) {
		res.add(new ArrayList<>(path));
		// 2. 递归终止条件 可以不加
		if(startIndex >= nums.length) {
			return;
		}

		// 3. 单层递归逻辑
		for (int i = startIndex; i < nums.length; i++) {
			// 做出选择
			path.add(nums[i]);
			// 回溯
			backtrack(path, nums, i+1);
			// 撤销选择
			path.remove(path.size()-1);
		}
	}*/

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, nums, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums, int startIndex) {
		res.add(new ArrayList<>(path));
		if(startIndex >= nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtrack(path, nums, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
