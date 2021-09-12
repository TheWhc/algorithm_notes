package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _322_零钱兑换
 * @Author: whc
 * @Date: 2021/07/25/19:48
 */
public class _322_零钱兑换 {

	/*// 完全背包
	public int coinChange(int[] coins, int amount) {

		// dp[j]表示:凑满j金额的背包最少需要多少硬币
		int[] dp = new int[amount+1];

		// 初始化
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;

		for (int j = 1; j <= amount; j++) {
			for (int i = 0; i < coins.length; i++) {
				// 这里要判断dp[j-coins[i]],因为可能会出现无法凑满count情况,比如coins=[2], amount=3, dp[1]=Integer.MAX_VALUE,不能直接计算
				if(j >= coins[i] && dp[j-coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
				}
			}
		}

		// 有可能出现无法凑满amount就直接返回-1
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}*/


	// 完全背包
	/*public int coinChange(int[] coins, int amount) {

		// dp[j]表示:凑满j金额的背包最少需要多少硬币
		int[] dp = new int[amount+1];

		// 初始化
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;

		// 先遍历物品,再遍历背包容量
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				// 不取当前coins[i], 取当前coins[i]
				if(dp[j-coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}


		// 有可能出现无法凑满amount就直接返回-1
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}*/

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[j]:表示凑满j的最少硬币数
	 *
	 * 2. 确定递推公式
	 * dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1)
	 *           不放入当前硬币   放入当前硬币
	 *
	 * 3. 初始化
	 * 背包容量为0时,最少硬币数一定为0
	 * 其它情况,赋值为Integer.MAX_VALUE,防止在递推公式被覆盖
	 *
	 * 4. 确定遍历顺序
	 * 外层遍历物品,内层遍历背包容量,反之也可以,因为求的是最少硬币数,跟顺序无关
	 *
	 *
	 */
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				if(dp[j - coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		_322_零钱兑换 _322_零钱兑换 = new _322_零钱兑换();
		_322_零钱兑换.coinChange(new int[]{2}, 3);
	}
}
