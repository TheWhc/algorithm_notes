package CodeTop;

/**
 * @ClassName: _62_不同路径
 * @Author: whc
 * @Date: 2021/07/26/10:33
 */
public class _62_不同路径 {

	/*public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m-1][n-1];
	}*/

	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];

		for (int j = 0; j < n; j++) {
			dp[j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j-1];
			}
		}

		return dp[n-1];
	}
}
