package 动态规划.子序列问题.不连续;

/**
 * @ClassName: _1143_最长公共子序列
 * @Author: whc
 * @Date: 2021/06/15/13:10
 */
public class _1143_最长公共子序列 {

	/**
	 *  思路: 动态规划
	 *
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]表示s1包含下标i在内的子串和s2包含下标j在内的子串的最长公共子序列
	 *  2. 确定递推公式
	 *  	if(s1[i] == s2[j]) {
	 * 			dp[i][j] = dp[i-1][j-1] + 1
	 *  	} else {
	 *  	 	dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
	 *  	}
	 *
	 *  3. 初始化
	 *  	i=0时, dp[0][j] = 0
	 *  	j=0时, dp[i][0] = 0
	 *  4. 遍历顺序
	 *  	外层遍历s1,内层遍历s2
	 *
	 *  时间: O(n * m)
	 *  空间: O(n * m)
	 */
	/*public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] dp = new int[m+1][n+1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		return dp[m][n];
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n * m)
	// 空间: O(n)
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[] dp = new int[n+1];
		int leftUp = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[j] = leftUp + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j-1]);
				}
				leftUp = temp;
			}
			leftUp = 0;
		}

		return dp[n];
	}
}
