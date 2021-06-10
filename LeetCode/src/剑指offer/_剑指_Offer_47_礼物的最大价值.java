package 剑指offer;

/**
 * @ClassName: _剑指_Offer_47_礼物的最大价值
 * @Author: whc
 * @Date: 2021/06/02/11:13
 */
public class _剑指_Offer_47_礼物的最大价值 {

	/**
	 *  思路: 动态规划
	 *
	 *  1. 只能向下或向右走,所以(i,j)由左边和上边过来,因此dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
	 *
	 *  时间: O(m*n)
	 *  空间: O(m*n)
	 */
	/*public int maxValue(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
			}
		}

		return dp[m][n];
	}*/

	// 优化到一维
	public int maxValue(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[j] = Math.max(dp[j-1], dp[j]) + grid[i-1][j-1];
			}
		}

		return dp[n];
	}
}
