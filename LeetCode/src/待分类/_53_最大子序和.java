package 待分类;

/**
 * @ClassName: 待分类._53_最大子序和
 * @Author: whc
 * @Date: 2021/03/14/13:07
 */
public class _53_最大子序和 {

	/*public int maxSubArray(int[] nums) {
		int sum = 0;
		int res = nums[0];
		for (int num : nums) {
			if(sum > 0) {
				sum += num;
			} else {
				sum = num;
			}
			res = Math.max(res, sum);
		}

		return res;
	}*/


	// 贪心算法
	/*public int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = nums[0];
		for (int i = 0; i < nums.length - 1; i++) {
			sum += nums[i+1];
			if(sum <= 0) {
				sum = 0;
			}
			res = Math.max(res, sum);
		}

		return res;
	}*/


	// 动态规划
	public int maxSubArray(int[] nums) {
		// 1. 确定dp数组
		int[] dp = new int[nums.length];

		// 2. 确定递推公式
		// dp[i] = Math.max(dp[i-1]+nums[i], nums[i])

		// 3. 初始化
		dp[0] = nums[0];

		// 4. 确定遍历顺序
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			res = Math.max(res, dp[i]);
		}

		return res;
	}

}
