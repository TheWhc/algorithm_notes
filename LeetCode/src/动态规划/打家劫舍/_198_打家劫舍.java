package 动态规划.打家劫舍;

/**
 * @ClassName: _198_打家劫舍
 * @Author: whc
 * @Date: 2021/06/13/11:30
 */
public class _198_打家劫舍 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i]: 考虑下标i(包括i)以内的房屋,最多可以偷窃的金额dp[i]
	 *
	 *  2. 确定递推公式
	 *  	dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
	 *  				不偷第i号房屋    偷第i号房屋
	 *  3. 初始化
	 *  	dp[0] = nums[0]
	 *      dp[1] = Math.max(nums[0], nums[1])
	 *
	 *  4. 确定遍历顺序
	 *  	从前往后遍历
	 *
	 *  5. 举例推导dp数组
	 *          2  7  9  3  1
	 * dp数组   2  7  11 11 12
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

		int[] dp = new int[nums.length];

		// dp[0]一定是1号房屋的值
		dp[0] = nums[0];
		// 取决于1号和2号房屋的最大值
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
		}

		return dp[nums.length-1];
	}
}
