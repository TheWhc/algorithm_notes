package CodeTop;

/**
 * @ClassName: _221_最大正方形
 * @Author: whc
 * @Date: 2021/09/11/11:51
 */
public class _221_最大正方形 {

	/**
	 * 思路： 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]: 以matrix[i][j]为右下角的正方形的最大边长
	 *
	 * 2. 确定递推公式
	 * dp[i][j] = Math.min(matrix[i-1][j-1], matrix[i][j-1], matrix[i-1][j]) + 1;
	 *                    左上角            左边        上边
	 *                选择最小边长 + 1
	 *
	 * 3. 初始化
	 *
	 * 4. 确定遍历顺序
	 * 从上到下,从左往右
	 *
	 */
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m+1][n+1];
		int maxSide = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(matrix[i-1][j-1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
					maxSide = Math.max(dp[i][j], maxSide);
				}
			}
		}

		return maxSide * maxSide;
	}
}
