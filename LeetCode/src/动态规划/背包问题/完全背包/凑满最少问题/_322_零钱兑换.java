package 动态规划.背包问题.完全背包.凑满最少问题;

/**
 * @ClassName: _322_零钱兑换
 * @Author: whc
 * @Date: 2021/06/28/12:00
 */
public class _322_零钱兑换 {

	// 求凑成总金额所需的最少的硬币个数

	// 完全背包 + 凑满问题 + 凑满最少问题
	/**
	 * 思路: 完全背包
	 * 1. 确定dp数组以及下标含义
	 * dp[j]: 凑成金额为amount的最少硬币数为dp[j]
	 *
	 * 2. 确定递推公式
	 * dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1)
	 *             不放入当前硬币   放入当前硬币
	 *
	 * 3. 初始化
	 * dp[0] = 0
	 * 凑成金额为0的硬币数一定为0
	 * 其它dp应该初始化为最大值,这样才能保证不被覆盖
	 *
	 * 4. 确定遍历顺序
	 * 先遍历物品,再遍历背包容量
	 * 或者先遍历背包容量,再遍历物品都可以(因为是最少硬币数,不是求排列数)
	 *
	 * 由于是求凑满问题,所以背包容量依然是正序遍历,保证元素可以被重复选取
	 *
	 * 5. 举例推导dp数组
	 * coins = [1, 2, 5], amount = 5
	 *   背包容量  0 1 2 3 4 5
	 * 物品0      0 1 2 3 4 5
	 * 物品1      0 1 1 2 2 3
	 * 物品2      0 1 1 2 2 1
	 *
	 * 最少硬币数为1
	 *
	 */
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];

		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		// 金额为0时需要的硬币数目为0
		dp[0] = 0;

		// 外层遍历物品
		for (int i = 0; i < coins.length; i++) {
			// 内层遍历背包容量
			// 正序遍历,保证物品可以重复放入
			for (int j = coins[i]; j <= amount; j++) {
				// 注意这里只有dp[j-coins[i]]不是初始最大值时,该位才有选择的必要,否则会发现整数溢出
				// 因为有可能出现无法用给定的硬币凑成目标数的情况,比如{2},amount=3
				if(dp[j-coins[i]] != Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
			}
		}

		// 返回的时候,需进行一下判断是不是可以凑成
		return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
	}
}
