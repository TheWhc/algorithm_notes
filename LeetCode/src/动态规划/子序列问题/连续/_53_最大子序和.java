package 动态规划.子序列问题.连续;

/**
 * @ClassName: _53_最大子序和
 * @Author: whc
 * @Date: 2021/06/15/14:42
 */
public class _53_最大子序和 {

	/**
	 *  思路: 贪心
	 *  遍历数组,如果出现sumOfChild < 0, 则开始重新计算连续子序和
	 *  注意sumOfChild要写在第一步进行判断,这样当出现[-2,-1,-4]时, 每次重新计算连续子序和, 都能把当前元素纳入计算范围
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	/*public int maxSubArray(int[] nums) {
		int sumOfChild = nums[0];

		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(sumOfChild < 0) {
				sumOfChild = 0;
			}
			sumOfChild += nums[i];
			res = Math.max(res, sumOfChild);
		}

		return res;
	}*/

	/**
	 *  思路: 动态规划
	 *  1. dp[i]表示包含下标i在内的最大子序和
	 *  2. if(dp[i-1] < 0) {
	 *         dp[i] = nums[i];
	 *     } else {
	 *         dp[i] = dp[i-1] + nums[i];
	 *     }
	 *  3. 初始化
	 *  	dp[0] = nums[0]
	 *  4. 遍历顺序
	 *  	从前往后遍历
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(dp[i-1] < 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i-1] + nums[i];
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n)
	// 空间: O(1)
	public int maxSubArray(int[] nums) {
		int dp = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(dp < 0) {
				dp = nums[i];
			} else {
				dp = dp + nums[i];
			}
			res = Math.max(res, dp);
		}

		return res;
	}

}
