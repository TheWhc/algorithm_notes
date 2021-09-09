package CodeTop;

import java.util.List;

/**
 * @ClassName: _120_三角形最小路径和
 * @Author: whc
 * @Date: 2021/09/09/22:50
 */
public class _120_三角形最小路径和 {

	/**
	 * 思路：动态规划
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]: 表示到达(i,j)最小路径
	 *
	 * 2. 确定递推公式
	 * 遍历每列时, dp[i][j] = Integer.MAX_VALUE
	 * 左上方, 当j != 0 时, dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + val);
	 * 正上方, 当j != i 时, dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + val);
	 *
	 * 3. 初始化
	 * dp[0][0] = triangle.get(0).get(0);
	 *
	 * 4. 确定遍历顺序
	 * 从上到下,从左到右
	 *
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n][n];

		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				int val = triangle.get(i).get(j);
				dp[i][j] = Integer.MAX_VALUE;
				if(j != 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + val);
				}

				if(j != i) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + val);
				}
			}
		}

		int res = dp[n-1][0];

		for (int j = 0; j < n; j++) {
			res = Math.min(res, dp[n-1][j]);
		}

		return res;
	}
}
