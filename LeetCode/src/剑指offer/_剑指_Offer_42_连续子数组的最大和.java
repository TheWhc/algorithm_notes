package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_42_连续子数组的最大和
 * @Author: whc
 * @Date: 2021/04/02/11:29
 */
public class _剑指_Offer_42_连续子数组的最大和 {
/*
	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}*/

	/**
	 *  思路: 动态规划
	 *
	 *  1. sum表示存储以前一个nums[i]结尾的子数组中,和最大的是多少
	 *  2. 如果sum < 0时, 将 sum = 0
	 *  3. 如果sum >= 0时, 则 sum += num
	 *  4. 每一次迭代,都要更新res,记录最大值
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int res = Integer.MIN_VALUE;

		for (int num : nums) {
			if(sum < 0) {
				sum = 0;
			}
			sum += num;
			res = Math.max(res, sum);
		}

		return res;
	}

	/**
	 *  思路: 动态规划
	 *
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i]:表示以nums[i]结尾的连续子数组的最大和
	 *  2. 确定递推公式
	 *  	- dp[i-1] > 0, dp[i] = dp[i-1] + nums[i]
	 *  	- dp[i-1] <= 0, dp[i] = nums[i]
	 *  3. 初始化
	 *  4. 确定遍历顺序
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// dp[i]以nums[i]结尾的连续子数组的最大和
		int[] dp = new int[nums.length];

		// 初始化
		dp[0] = nums[0];

		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(dp[i-1] > 0) {
				dp[i] = dp[i-1] + nums[i];
			} else {
				dp[i] = nums[i];
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}
*/
	public static void main(String[] args) {
		maxSubArray(new int[]{-2,1});
	}
}
