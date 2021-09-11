package CodeTop;

/**
 * @ClassName: _63_不同路径II
 * @Author: whc
 * @Date: 2021/09/11/19:10
 */
public class _63_不同路径II {

	/**
	 * 思路: 动态规划
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		// dp[i][j]表示(0,0)到达(i,j)有几条路径
		int[][] dp = new int[m][n];

		// 初始化
		for (int i = 0; i < m; i++) {
			if(obstacleGrid[i][0] != 1) {
				dp[i][0] = 1;
			} else {
				// 遇到1,跳出循环,后面的走不通
				break;
			}
		}

		for (int j = 0; j < n; j++) {
			if(obstacleGrid[0][j] != 1) {
				dp[0][j] = 1;
			} else {
				break;
			}
		}


		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] != 1) {
					dp[i][j] += dp[i-1][j] + dp[i][j-1];
				}
			}
		}

		return dp[m-1][n-1];
	}
}
