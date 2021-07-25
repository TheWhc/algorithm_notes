package CodeTop;

/**
 * @ClassName: _64_最小路径和
 * @Author: whc
 * @Date: 2021/07/25/21:26
 */
public class _64_最小路径和 {

	/*public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];



		for (int i = 0; i <= m; i++) {
			dp[i][0] = Integer.MAX_VALUE;
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = Integer.MAX_VALUE;
		}

		dp[1][1] = grid[0][0];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == 1 && j == 1) {
					continue;
				}
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];

			}
		}

		return dp[m][n];
	}*/


	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		dp[0][0] = grid[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}

		for (int j = 1; j < n; j++) {
			dp[0][j] = grid[0][j] + dp[0][j-1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

			}
		}

		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		System.out.println(new _64_最小路径和().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
	}

}
