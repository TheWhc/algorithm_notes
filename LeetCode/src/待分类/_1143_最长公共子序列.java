package 待分类;

/**
 * @ClassName: 待分类._1143_最长公共子序列
 * @Author: whc
 * @Date: 2021/03/22/10:22
 */
public class _1143_最长公共子序列 {
	/*public int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if(text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[text1.length()][text2.length()];
	}*/

	/*public int longestCommonSubsequence(String text1, String text2) {
		// 1. 确定dp数组及含义
		// dp[i][j]表示以下标为i-1和text1和以下标为j-1的text2的最长公共子序列
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];


		// 2. 确定递推公式
		// text1[i-1] == text2[j-1]  dp[i][j] = dp[i-1][j-1] + 1
		// text1[i-1] != text2[j-1]  dp[i][j] = Max{dp[i][j-1], dp[i-1][j]}

		// 3. 初始化
		for (int i = 0; i <= text1.length(); i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= text2.length(); j++) {
			dp[0][j] = 0;
		}

		// 4. 确定遍历顺序
		// 从左到右 从上到下
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

	public int longestCommonSubsequence(String text1, String text2) {
		// 1. 确定dp数组以及下标含义dp[i][j] 代表 text1[i-1] 与 text[j-1]最长公共子序列
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];

		// 2. 确定递推公式
		// text1[i-1] == text2[j-1]  dp[i][j] = dp[i-1][j-1] + 1
		// text1[i-1] != text2[j-1]  dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j])

		// 3. 初始化
		for (int i = 0; i <= text1.length(); i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= text2.length(); j++) {
			dp[0][j] = 0;
		}

		// 4. 确定遍历顺序
		// 从上到下 从左到右
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}

		return dp[text1.length()][text2.length()];
	}
}
