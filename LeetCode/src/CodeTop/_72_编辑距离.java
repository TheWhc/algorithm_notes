package CodeTop;

/**
 * @ClassName: _72_编辑距离
 * @Author: whc
 * @Date: 2021/07/24/20:59
 */
public class _72_编辑距离 {

	/*public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m+1][n+1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					// dp[i-1][j]对应删除操作
					// dp[i][j-1]对应添加操作
					// dp[i-1][j-1]对应更改操作
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				}
			}
		}

		return dp[m][n];
	}*/

	// 空间优化
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[] dp = new int[n+1];

		for (int j = 0; j <= n; j++) {
			dp[j] = j;
		}

		int leftTop = 0;

		for (int i = 1; i <= m; i++) {
			dp[0] = i - 1;
			for (int j = 1; j <= n; j++) {
				int tmp = dp[j];
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[j] = leftTop;
				} else {
					// dp[i-1][j]对应删除操作
					// dp[i][j-1]对应添加操作
					// dp[i-1][j-1]对应更改操作
					dp[j] = Math.min(Math.min(dp[j], dp[j-1]), leftTop) + 1;
				}
				leftTop = tmp;
			}

			leftTop = dp[0];
		}

		return dp[n];
	}
}
