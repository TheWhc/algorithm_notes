package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _剑指_Offer_60_n个骰子的点数
 * @Author: whc
 * @Date: 2021/06/09/11:56
 */
public class _剑指_Offer_60_n个骰子的点数 {

	/**
	 *  思路: 动态规划
	 *
	 *  1. 确定dp数组以及下标含义, 用二维数组表示dp[i][j]代表投掷完i个骰子后,点数为j出现的次数
	 *  2. 确定递推公式, dp[i][j] 由前一阶段推出 即dp[i-1][j-{1,6}]
	 *  3. 初始化,投掷一个骰子时, dp[1][j]
	 *  4. 确定遍历顺序,从前往后,i从2开始递增到n
	 *
	 *  时间: O(n^2)
	 *  空间: O(n^2)
	 */
	public double[] dicesProbability(int n) {
		// dp[i][j]表示投掷完i枚后,点数j出现的次数
		int[][] dp = new int[n + 1][6 * n + 1];

		// 递推公式
		// 最后一个阶段的骰子数 由 前一个阶段的骰子数转化过来
		// dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] + dp[i-1][j-4] + dp[i-1][j-5] + dp[i-1][j-6]

		// 初始化
		// 投掷一枚骰子时
		for (int j = 1; j <= 6; j++) {
			dp[1][j] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= 6 * i; j++) {
				for (int k = 1; k <= 6; k++) {
					if(j - k <= 0) {
						break;
					}
					dp[i][j] += dp[i-1][j-k];
				}
			}
		}

		double[] res = new double[6 * n - n + 1];

		for (int i = n; i <= 6 * n; i++) {
			res[i - n] = (double)dp[n][i] / Math.pow(6, n);
		}

		return res;
	}

}
