package CodeTop;

/**
 * @ClassName: _516_最长回文子序列
 * @Author: whc
 * @Date: 2021/09/25/14:47
 */
public class _516_最长回文子序列 {

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		// 初始化
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		// 从下往上,从左往右
		for (int i = n-1; i >= 0; i--) {
			for (int j = i+1; j < n; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}

		return dp[0][n-1];
	}
}
