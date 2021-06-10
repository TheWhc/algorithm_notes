package 动态规划.背包问题;

/**
 * @ClassName: 待分类._70_爬楼梯
 * @Author: whc
 * @Date: 2021/05/04/13:44
 */
public class _70_爬楼梯 {

	public int climbStairs(int n) {
		// 1. 确定dp数字以及下标含义
		// dp[j]表示刚好爬到第j阶 方法数
		int[] dp = new int[n+1];

		// 2. 确定递推公式
		// dp[j] += dp[j-nums[i]]

		// 3. 初始化
		dp[0] = 1;

		// 4. 确定遍历顺序 求排列数 先背包重量 后物品
		// 如果改为最多每次可以爬m步  将2改为m即可 即每次可以爬[1 - m]个台阶
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= 2; i++) {
				if(j >= i) {
					dp[j] += dp[j-i];
				}
			}
		}

		return dp[n];
	}
}
