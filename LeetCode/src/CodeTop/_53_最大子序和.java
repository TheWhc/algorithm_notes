package CodeTop;

/**
 * @ClassName: _53_最大子序和
 * @Author: whc
 * @Date: 2021/07/20/12:08
 */
public class _53_最大子序和 {

	/*public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];

		dp[0] = nums[0] < 0 ? 0 : nums[0];

		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(dp[i-1] < 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = nums[i] + dp[i-1];
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}*/

	// 贪心
	public int maxSubArray(int[] nums) {
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(sum < 0) {
				sum = 0;
			}
			sum += nums[i];
			res = Math.max(res, sum);
		}
		return res;
	}

}
