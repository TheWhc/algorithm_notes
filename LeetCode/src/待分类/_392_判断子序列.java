package 待分类;

/**
 * @ClassName: 待分类._392_判断子序列
 * @Author: whc
 * @Date: 2021/04/09/13:07
 */
public class _392_判断子序列 {
	public boolean isSubsequence(String s, String t) {
		int[][] dp = new int[s.length() + 1][t.length() + 1];

		// 初始化
		for (int i = 0; i <= s.length(); i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= t.length(); j++) {
			dp[0][j] = 0;
		}

		int maxLength = 0;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				maxLength = Math.max(dp[i][j], maxLength);
			}
		}

		if(maxLength == s.length()) {
			return true;
		}

		return false;
	}
}
