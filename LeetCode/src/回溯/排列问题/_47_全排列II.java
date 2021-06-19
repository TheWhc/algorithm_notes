package 回溯.排列问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _47_全排列II
 * @Author: whc
 * @Date: 2021/06/19/12:54
 */
public class _47_全排列II {

	// 排列元素重复问题,不需要startIndex变量,需要used数组记录path里放了哪些元素(同一树枝被使用过), 排重同一树层相同元素

	/**
	 *  思路: 回溯
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(int[] nums, boolean[] used)
	 * 	  nums: 选择列表
	 * 	  used: 记录path哪些元素使用了
	 * 	  		- used[i-1] == false: 同一树层nums[i-1]使用过
	 * 	  		- used[i] == true: 同一树枝nums[i]没被使用过开始处理
	 *
	 * 2. 回溯函数终止条件
	 * 	  path.size() == nums.length时
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从0开始
	 *
	 * 时间: O(n!) : 第一层节点为n,第二层每个分支都延伸了n-1个分支,再往下就是n-2个分支,所以一直到叶子节点n * n-1 * n-2 * .... 1 = n!
	 * 空间: O(n) : 递归深度为n,所以额外空间为O(n)
	 */

	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(nums, used);
		return res;
	}

	private void backtrack(int[] nums, boolean[] used) {
		if(path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// 同一树层: 排除同层重复的元素
			if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
				continue;
			}

			// 同一树枝: 未被使用过的元素
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
