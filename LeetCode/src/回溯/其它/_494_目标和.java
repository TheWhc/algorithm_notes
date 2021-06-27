package 回溯.其它;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _494_目标和
 * @Author: whc
 * @Date: 2021/06/27/11:32
 */
public class _494_目标和 {

	/**
	 * 思路: 暴力回溯
	 * 1. 确定递归函数返回值以及参数的含义
	 * void backtrack(int[] nums, int[] choice, int startIndex, int target)
	 *
	 * @param nums
	 * @param choice 选择列表
	 * @param startIndex 当前元素的下标
	 * @param target 目标值
	 *
	 * 2. 回溯终止条件
	 * startIndex == nums.length时,进行判断target == 0,如果是,则结果+1
	 *
	 * 3. 单层搜索的过程
	 * 从0开始遍历到2, 因为提供了-1和1代表-和+, 所以构建一个选择数组, 遍历这个数组
	 */
	/*int ans = 0;
	public int findTargetSumWays(int[] nums, int target) {
		int[] choice = new int[]{-1, 1};

		backtrack(nums, choice, 0, target);
		return ans;
	}

	*//**
	 *
	 * @param nums
	 * @param choice 选择列表
	 * @param startIndex 当前元素的下标
	 * @param target 目标值
	 *//*
	private void backtrack(int[] nums, int[] choice, int startIndex, int target) {
		if(startIndex == nums.length) {
			if(target == 0) {
				ans++;
			}
			return;
		}

		for (int i = 0; i < 2; i++) {
			backtrack(nums, choice, startIndex+1, target+nums[startIndex] * choice[i]);
		}
	}*/


	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}

		if((sum + target) % 2 == 1) {
			return 0;
		}
		int bagSize = (sum + target) / 2;
		Arrays.sort(nums);
		backtrack(nums, bagSize, 0, 0);
		return res.size();
	}

	private void backtrack(int[] nums, int target, int sum, int startIndex) {
		if(sum == target) {
			res.add(new ArrayList(path));
			// 这里不应该直接返回,因为可能出现[0,0,0,0] 目标和为0的情况, 那么是继续递归下去的, 因为控制的是startIndex的下标
		}

		for(int i = startIndex; i < nums.length && sum + nums[i] <= target; i++) {
			sum += nums[i];
			path.add(nums[i]);
			backtrack(nums, target, sum, i+1);
			sum -= nums[i];
			path.remove(path.size()-1);
		}
	}
}
