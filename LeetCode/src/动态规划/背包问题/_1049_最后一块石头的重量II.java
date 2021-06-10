package 动态规划.背包问题;

/**
 * @ClassName: _1049_最后一块石头的重量II
 * @Author: whc
 * @Date: 2021/05/03/10:28
 */
public class _1049_最后一块石头的重量II {

	// 01背包问题
	// 尽量将石头分成重量相同的两堆
	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}
		int target = sum / 2;
		// 1. 确定dp数组以及下标含义
		// dp[j] : 容量为j的背包最多可以放入的石头最大重量
		int[] dp = new int[target+1];

		// 2. 确定递推公式
		// 物品重量为stones[i], 价值也是stones[i]
		// dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]

		// 3. 初始化 均为0

		// 4. 确定遍历顺序
		// 先遍历物品 再遍历重量
		for (int i = 0; i < stones.length; i++) {
			// 倒叙遍历
			for (int j = target; j >= stones[i]; j--) {
				// 不放   放入 求最大值
				dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
			}
		}

		// 一堆石头的总重量是dp[target], 另一堆就是sum - dp[target]
		// 且target是向下取整,所以dp[targer] <= sum - dp[target]
		return sum - dp[target] - dp[target];
	}
}
