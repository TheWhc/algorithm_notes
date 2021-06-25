package 动态规划.基础题目;

/**
 * @ClassName: _63_不同路径II
 * @Author: whc
 * @Date: 2021/06/25/11:39
 */
public class _63_不同路径II {

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]:表示从(0,0)到(i,j)有多少条不同的路径
	 * 2. 确定递推公式
	 * // 当前格子不是障碍时
	 * if(obstacleGrid[i][j] != 1)
	 * 		dp[i][j] = dp[i-1][j] + dp[i][j-1]
	 * 3.初始化
	 * 在第0行时,如果遇到obstacleGrid[0][j]为1时,那么直接结束循环,后面都为0
	 * 在第0列时,如果遇到obstacleGrid[i][0]为1时,那么直接结束循环,后面都为0
	 * 4. 确定遍历顺序
	 * 从上到下
	 * 从左往右
	 *
	 * 时间: O(n*m)
	 * 空间: O(n*m)
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			// 没有障碍的时候
			if(obstacleGrid[i][0] != 1) {
				dp[i][0] = 1;
			} else {
				// 遇到障碍,则结束循环,后面都为0
				break;
			}
		}

		for (int j = 0; j < m; j++) {
			if(obstacleGrid[0][j] != 1) {
				dp[0][j] = 1;
			} else {
				// 遇到障碍,则结束循环,后面都为0
				break;
			}
		}


		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				// 如果当前格子遇到障碍,则继续下一轮
				if(obstacleGrid[i][j] == 1) {
					continue;
				}
				// 上一个格子向右 或者 上一个格子向下
				dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[n-1][m-1];
	}
}
