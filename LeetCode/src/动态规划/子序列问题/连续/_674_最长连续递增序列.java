package 动态规划.子序列问题.连续;

/**
 * @ClassName: _674_最长连续递增序列
 * @Author: whc
 * @Date: 2021/06/15/13:43
 */
public class _674_最长连续递增序列 {

	/**
	 *  思路: 贪心
	 *  1. 遍历数组,统计连续增长的子序列长度
	 *  2. 一旦遇到不连续的元素,则重新开始统计
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	/*public int findLengthOfLCIS(int[] nums) {
		int res = 1;
		int lenOfChild = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1]) {
				lenOfChild++;
			} else {
				// 重新开始统计
				lenOfChild = 1;
			}
			res = Math.max(res, lenOfChild);
		}
		return res;
	}*/

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i]表示包含下标i在内的最长连续递增序列
	 *  2. 确定递推公式
	 *  	if(nums[i] == nums[i-1]) {
	 *  	 	dp[i] = dp[i-1] + 1;
	 *  	} else {
	 *  	 	dp[i] = 1;
	 *  	}
	 *  3. 初始化
	 *  	dp[0] = 1
	 *  4. 遍历顺序
	 *  	从前往后遍历
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int findLengthOfLCIS(int[] nums) {
		int[] dp = new int[nums.length];

		dp[0] = 1;

		int res = 1;

		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1]) {
				dp[i] = dp[i-1] + 1;
			} else {
				dp[i] = 1;
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n)
	// 空间: O(1)
	public int findLengthOfLCIS(int[] nums) {
		int dp = 1;

		int res = 1;

		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1]) {
				dp = dp + 1;
			} else {
				dp = 1;
			}
			res = Math.max(res, dp);
		}

		return res;
	}

}
