package 回溯.子集问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _90_子集II
 * @Author: whc
 * @Date: 2021/06/19/10:33
 */
public class _90_子集II {

	/**
	 *  思路: 回溯
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(int[] nums, boolean[] used, int startIndex)
	 * 	  nums: 选择列表
	 * 	  used: 访问数组,判断同层节点是否已经遍历过
	 * 	  startIndex: 用于记录本层递归中,集合从哪里开始遍历
	 *
	 * 2. 回溯函数终止条件
	 * 	  startIndex == nums.length时
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始
	 *
	 */
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(nums, used, 0);
		return res;
	}

	private void backtrack(int[] nums, boolean[] used, int startIndex) {
		res.add(new ArrayList<>(path));

		if(startIndex == nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
				continue;
			}
			path.add(nums[i]);
			used[i] = true;
			backtrack(nums, used, i+1);
			used[i] = false;
			path.remove(path.size()-1);
		}
	}
}
