package 动态规划.背包问题;

/**
 * @ClassName: _416_分割等和子集
 * @Author: whc
 * @Date: 2021/05/02/12:37
 */
public class _416_分割等和子集 {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if(sum % 2 == 1) {
			return false;
		}
		int target = sum / 2;
		// 1. 确定dp数组以及下标含义
		// dp[i]表示背包总容量为i,最大可以凑成i的子集总和为dp[i]
		int[] dp = new int[target+1];

		// 2. 确定递推公式
		// dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i])    物品的重量为nums[i], 价值也是nums[i]

		// 3. 初始化
		// 默认为0

		// 4. 确定遍历顺序
		// 先遍历物品,再遍历背包重量
		for (int i = 0; i < nums.length; i++) {
			// 倒叙遍历
			for (int j = target; j >= nums[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
			}
		}

		// 如果dp[target] ==  target 说明集合中的子集正好可以凑成总和 target
		return dp[target] == target;
	}
}
