package CodeTop;

/**
 * @ClassName: _518_零钱兑换II
 * @Author: whc
 * @Date: 2021/07/25/20:21
 */
public class _518_零钱兑换II {

	// 完全背包 + 组合问题
	/*public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];

		dp[0] = 1;

		// 先遍历物品
		for (int i = 0; i < coins.length; i++) {
			// 再遍历背包容量
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] += dp[j-coins[i]];
			}
		}

		return dp[amount];
	}
*/

	/**
	 * 思路：动态规划
	 * 完全背包 + 组合问题
	 */
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount+1];

		dp[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] += dp[j-coins[i]];
			}
		}

		return dp[amount];
	}

}
