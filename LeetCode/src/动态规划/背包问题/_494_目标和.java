package 动态规划.背包问题;

/**
 * @ClassName: _494_目标和
 * @Author: whc
 * @Date: 2021/05/03/10:37
 */
public class _494_目标和 {

	/**
	 * left组合 - right组合 = target
	 * left + right = sum
	 * left组合 - (sum - left) = target
	 * left = (target + sum) / 2
	 * left为整数组合
	 */

	/*List<List<Integer>> res = new ArrayList<>();
	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if(target > sum) return 0;
		if ((target + sum) % 2 == 1) return 0;

		int bagSize = (target + sum) / 2;

		List<Integer> path = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(path, nums, 0, bagSize);
		return res.size();

	}

	private void backtrack(List<Integer> path, int[] nums, int startIndex, int count) {
		if(count == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < nums.length && count - nums[i] >= 0; i++) {
			path.add(nums[i]);
			backtrack(path, nums, i+1, count-nums[i]);
			path.remove(path.size()-1);
		}
	}*/

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		// 加法的背包总和为x, 减法的背包总和为y
		// 因此 x + y = sum 以及 x - y = target
		// 得 x = (target + sum) / 2 向下取整
		if(target > sum) return 0;

		// 不是正整数
		if((target + sum) % 2 == 1) {
			return 0;
		}

		int bagSize = (target + sum) / 2;

		// 1. 定义dp数组以及下标含义
		// dp[j]表示填满j容积的包, 有dp[j]种方法
		int[] dp = new int[bagSize+1];

		// 2. 确定递推公式  填满->方法数需要累加
		// 求组合类问题的公式 都是类似这种
		// dp[j] += dp[j-nums[i]]

		// 3. 初始化
		// 什么都不放,也是一种方法
		dp[0] = 1;

		// 4. 确定遍历顺序
		for (int i = 0; i < nums.length; i++) {
			for (int j = bagSize; j >= nums[i]; j--) {
				dp[j] += dp[j-nums[i]];
			}
		}

		return dp[bagSize];
	}

}
