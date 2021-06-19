package 回溯.排列问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _46_全排列
 * @Author: whc
 * @Date: 2021/06/19/11:22
 */
public class _46_全排列 {

	// 排列元素不重复问题,不需要startIndex变量,需要used数组记录path里放了哪些元素

	/**
	 *  思路: 回溯
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(int[] nums, boolean[] used)
	 * 	  nums: 选择列表
	 * 	  used: 记录path哪些元素使用了
	 *
	 * 2. 回溯函数终止条件
	 * 	  path.size() == nums.length时
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从0开始
	 *
	 */
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
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
			if(!used[i]) {
				path.add(nums[i]);
				used[i] = true;
				backtrack(nums, used);
				used[i] = false;
				path.remove(path.size()-1);
			}
		}
	}
}
