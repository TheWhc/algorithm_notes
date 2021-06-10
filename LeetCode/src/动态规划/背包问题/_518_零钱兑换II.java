package 动态规划.背包问题;

/**
 * @ClassName: _518_零钱兑换II
 * @Author: whc
 * @Date: 2021/05/04/11:35
 */
public class _518_零钱兑换II {

	public int change(int amount, int[] coins) {
		// 1. 定义dp数组以及下标含义
		// dp[j]表示凑成总金额为j的货币组合数
		int[] dp = new int[amount+1];

		// 2. 确定递推公式(求刚好凑成的组合数都是以下这个公式)
		// dp[j] += dp[j-coins[i]]

		// 3. 初始化
		dp[0] = 1;

		// 4. 确定遍历顺序
		// 先遍历物品,再遍历背包重量(虽然是完全背包,但是这里反之不可以,反之的话会计算出排列数)
		// 如果是求排列数,则先遍历背包重量,再遍历物品
		for (int i = 0; i < coins.length; i++) {
			// 和之前不同的是,这里是正序遍历
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] += dp[j-coins[i]];
			}

			for (int k = 0; k < amount; k++) {
				System.out.print(dp[k] + " ");
			}
			System.out.println();
		}

		return dp[amount];
	}
}
