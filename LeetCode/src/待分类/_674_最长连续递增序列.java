package 待分类;

import java.util.Arrays;

/**
 * @ClassName: 待分类._674_最长连续递增序列
 * @Author: whc
 * @Date: 2021/04/08/12:31
 */
public class _674_最长连续递增序列 {
	// 动态规划解法
	/*public int findLengthOfLCIS(int[] nums) {
		// 1. 确定dp数组以及下标含义 dp[i]代表 以下标为i结尾的数组的连续最长递增子序列序列
		int[] dp = new int[nums.length];

		// 2. 确定递推公式  nums[i+1] > nums[i] dp[i+1] = dp[i] + 1

		// 3. 初始化
		Arrays.fill(dp, 1);

		int result = 0;
		// 4. 确定遍历顺序 从前往后
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] > nums[i]) {
				dp[i+1] = dp[i] + 1;
			}
			result = Math.max(result, dp[i+1]);
		}

		return result;
	}*/

	// 贪心算法
	public int findLengthOfLCIS(int[] nums) {
		if(nums.length == 0)
			return 0;
		int result = 1;
		int count = 1;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] > nums[i]) {
				count++;
			} else {
				count = 1;
			}
			result = Math.max(result, count);
		}

		return result;
	}
}
