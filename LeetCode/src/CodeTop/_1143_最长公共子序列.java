package CodeTop;

/**
 * @ClassName: _1143_最长公共子序列
 * @Author: whc
 * @Date: 2021/07/24/16:58
 */
public class _1143_最长公共子序列 {

	/*public int longestCommonSubsequence(String text1, String text2) {
		// dp[i][j]表示text1包含下标i在内的子串与text2包含下标j在内的子串的最长公共子序列
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];

		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		return dp[text1.length()][text2.length()];
	}*/

	// 空间优化
	public int longestCommonSubsequence(String text1, String text2) {
		// dp[i][j]表示text1包含下标i在内的子串与text2包含下标j在内的子串的最长公共子序列
		int[] dp = new int[text2.length() + 1];
		int leftUp = 0;
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
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

		return dp[text2.length()];
	}
}
