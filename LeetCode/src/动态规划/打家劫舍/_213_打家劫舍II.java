package 动态规划.打家劫舍;

/**
 * @ClassName: _213_打家劫舍II
 * @Author: whc
 * @Date: 2021/06/13/11:52
 */
public class _213_打家劫舍II {

	// 成环偷盗问题

	/**
	 *  思路: 动态规划
	 *
	 *  成环的偷盗问题分为三种情况:
	 *  	1. 不考虑首尾元素偷盗
	 *      2. 考虑首部元素, 不考虑尾部元素偷盗
	 *      3. 考虑尾部元素, 不考虑首部元素偷盗
	 *
	 *      其中2和3情况已经包括了1, 所以1情况可以忽略
	 *      所以最后结果取 Math.max(情况2,情况3)
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		if(nums.length == 1) {
			return nums[0];
		}

		return Math.max(robRange(nums, 0, nums.length-1), robRange(nums, 1, nums.length));
	}

	private int robRange(int[] nums, int start, int end) {
		int[] dp = new int[end - start];

		if(dp.length == 1) {
			return nums[start];
		}

		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start+1]);

		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i]);
		}

		return dp[dp.length-1];
	}

}
