package 动态规划.背包问题;

import java.util.Arrays;

/**
 * @ClassName: _279_完全平方数
 * @Author: whc
 * @Date: 2021/05/04/15:30
 */
public class _279_完全平方数 {

	public int numSquares(int n) {
		// 1. 确定dp数组以及下标含义
		// dp[j]表示凑满容量为j的完全平方数数量
		int[] dp = new int[n+1];

		// 2. 确定递推公式
		// i从1开始 到 i * i <= j
		// dp[j] = Math.min(dp[j], dp[j-i*i] + 1)

		// 3. 初始化
		// 求最小,应该用最大值初始化 防止被覆盖
		Arrays.fill(dp, Integer.MAX_VALUE);
		// 背包容量为0的时, 平方数为0 题目是从1开始的
		dp[0] = 0;

		// 4. 确定遍历顺序 先遍历物品 再遍历背包容量 反之也可以
		for (int i = 1; i * i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if(i*i <= j && dp[j-i*i] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
				}
			}
		}

		return dp[n];
	}
}
