package CodeTop;

/**
 * @ClassName: _213_打家劫舍II
 * @Author: whc
 * @Date: 2021/09/12/13:51
 */
public class _213_打家劫舍II {

	/**
	 * 思路: 动态规划
	 * 成环的偷盗问题
	 *
	 * 1. 考虑包含首元素,不包含尾元素
	 * 2. 考虑包含尾元素,不包含首元素
	 *
	 * 1和2情况已经包括了不包含首尾元素的情况了
	 *
	 * 1、确定dp数组以及下标含义
	 * dp[i]表示偷取第i间房屋的最高金额
	 *
	 * 2、确定递推公式
	 * dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i])
	 *                不偷取当前屋子    偷取当前屋子
	 *
	 * 3、确定遍历顺序
	 * 从前往后遍历
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
		dp[1] = Math.max(dp[0], nums[start+1]);

		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i]);
		}

		return dp[dp.length-1];
	}
}
