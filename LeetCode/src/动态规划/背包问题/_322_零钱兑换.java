package 动态规划.背包问题;

import java.util.Arrays;

/**
 * @ClassName: 待分类._322_零钱兑换
 * @Author: whc
 * @Date: 2021/05/04/14:03
 */
public class _322_零钱兑换 {

	public int coinChange(int[] coins, int amount) {
		// 1. 确定dp数组
		// dp[j] 表示凑成amount最少硬币数量
		int[] dp = new int[amount+1];

		// 2. 确定递推公式
		// 凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，
		// 那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
		// dp[j] = Math.min(dp[j], dp[j-coins[i] + 1]

		// 3. 初始化
		// 防止被覆盖
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		// 4. 确定遍历顺序
		// 先遍历物品 再遍历背包重量
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				// 比如[2], amount = 3时
				if(dp[j-coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}

		if(dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}

		return dp[amount];
	}

}
