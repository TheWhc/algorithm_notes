package top100;

/**
 * @ClassName: _221_最大正方形
 * @Author: whc
 * @Date: 2021/05/13/13:28
 */
public class _221_最大正方形 {

	/**
	 *  思路: 动态规划
	 *  递推公式中选择左边,上边,左上角三个点最小值,然后加1
	 *  若选择最大值,以右下角进行扩展时无法构成正方形
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 */
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		// dp[i][j] 表示(i,j)为右下角正方形的最大边长
		int[][] dp = new int[n][m];

		// 确定递推公式
		// dp[i][j]为0时,dp[i][j] = 0
		// dp[i][j]为1时,dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1

		int res = 0;

		// 初始化
		for (int i = 0; i < n; i++) {
			dp[i][0] = matrix[i][0] - '0';
			res = Math.max(dp[i][0], res);
		}

		for (int j = 0; j < m; j++) {
			dp[0][j] = matrix[0][j] - '0';
			res = Math.max(dp[0][j], res);
		}

		// 遍历顺序
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
					res = Math.max(dp[i][j], res);
				}
			}
		}

		return res * res;
	}

}
