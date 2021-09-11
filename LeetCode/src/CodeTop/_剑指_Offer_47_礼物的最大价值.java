package CodeTop;

/**
 * @ClassName: _剑指_Offer_47_礼物的最大价值
 * @Author: whc
 * @Date: 2021/09/11/10:51
 */
public class _剑指_Offer_47_礼物的最大价值 {

	/*public int maxValue(int[][] grid) {
		int[][] dp = new int[grid.length+1][grid[0].length+1];

		for (int i = 1; i <= grid.length; i++) {
			for (int j = 1; j <= grid[0].length; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
			}
		}

		return dp[grid.length][grid[0].length];
	}*/

	// 优化
	public int maxValue(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n+1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[j] = Math.max(dp[j], dp[j-1]) + grid[i-1][j-1];
			}
		}

		return dp[n];
	}
}
