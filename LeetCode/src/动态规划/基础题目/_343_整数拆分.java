package 动态规划.基础题目;

/**
 * @ClassName: _343_整数拆分
 * @Author: whc
 * @Date: 2021/06/25/14:42
 */
public class _343_整数拆分 {

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[i]: 分拆数字i,得到的最大乘积为dp[i]
	 *
	 * 2. 确定递推公式
	 * dp[i]有两个渠道可以得到最大乘积:
	 * 		- 一个是j * (i - j)直接相乘 (单纯的把数字拆分为两个数字直接相乘)
	 * 	 	- 一个是j * dp[i - j], 相当于拆分dp[i - j] (将一个数字强制拆成2份以及2份以上)
	 * 	 j的取值范围为[1,i-1)
	 * 	 为什么j不等于i-1?
	 * 	 因为在j=1时,已经计算过 1 * (i-1),没必要重复计算了
	 * dp[i] = Math.max(dp[i], j * (i - j), j * dp[i - j])
	 *
	 * 3. 初始化
	 * dp[2] = 1
	 *
	 * 4. 确定遍历顺序
	 * 从前往后遍历
	 *
	 * 5. 举例推导
	 * 比如 拆分5时
	 * dp[5] = dp[5], 1 * 4, 1 * dp[4]
	 * dp[5] = dp[5], 2 * 3, 2 * dp[3]
	 * dp[5] = dp[5], 3 * 2, 3 * dp[2]
	 *
	 * 时间: O(n^2)
	 * 空间: O(n)
	 */
	/*public int integerBreak(int n) {
		int[] dp = new int[n+1];

		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < i - 1; j++) {
				dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i-j]));
			}
		}

		return dp[n];
	}*/


	/**
	 * 思路: 贪心法
	 * 每次拆分为3,如果剩余4,则保留4,然后相乘
	 */
	public int integerBreak(int n) {
		if(n == 2) {
			return 1;
		}
		if(n == 3) {
			return 2;
		}
		if(n == 4) {
			return 4;
		}

		int result = 1;
		while(n > 4) {
			result *= 3;
			n -= 3;
		}

		return result * n;
	}
}
