package 动态规划.背包问题;

/**
 * @ClassName: _377_组合总和Ⅳ
 * @Author: whc
 * @Date: 2021/05/04/13:29
 */
public class _377_组合总和Ⅳ {

	public static void main(String[] args) {
		combinationSum4(new int[]{1,2,3}, 4);
	}

	public static int combinationSum4(int[] nums, int target) {
		// 1. 定义dp数组以及下标含义
		// dp[j]表示刚好凑成j组合数
		int[] dp = new int[target+1];

		// 2. 确定递推公式
		// dp[j] += dp[j-nums[i]]

		// 3. 初始化
		dp[0] = 1;

		// 4. 确定遍历顺序
		// 求排列数,先遍历背包重量,再遍历物品
		for (int j = 0; j <= target; j++) {
			for (int i = 0; i < nums.length; i++) {
				if(j >= nums[i]) {
					dp[j] += dp[j-nums[i]];
				}
			}
			System.out.println(dp[j]);
		}

		return dp[target];
	}
}
