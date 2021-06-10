package 待分类;

/**
 * @ClassName: 待分类._10_正则表达式匹配
 * @Author: whc
 * @Date: 2021/04/07/11:24
 */
public class _10_正则表达式匹配 {

	public static void main(String[] args) {
		isMatch("a", ".*..a*");
	}

	public static boolean isMatch(String s, String p) {
		// 1. 确定dp数组以及下标含义  dp[i][j]表示以i-1为下标的s和以j-1为下标的p字符串是否匹配
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		// 2. 确定递推公式
		// s[i-1] == p[j-1]  dp[i][j] = dp[i-1][j-1]
		// p[j-1] == '.'     dp[i][j] = dp[i-1][j-1]
		// p[j-1] == '*'     dp[i][j-2]==true, dp[i][j] = true 前面的字符出现0次
		//              否则看如果 s[i] = p[j-2] || s[i] = '.'  看dp[i-1][j] = true, 则dp[i][j] = true ; // 前面字符出现多次

		// 3. 初始化
		dp[0][0] = true;
		for (int j = 1; j <= p.length(); j++) {
			if(j > 1) {
				if (p.charAt(j - 1) == '*') {
					dp[0][j] = dp[0][j - 2];
				} else {
					dp[0][j] = false;
				}
			}
		}

		// 4. 遍历
		// 从左到右 从上到下
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
					dp[i][j] = dp[i-1][j-1];
				} else {
					if(p.charAt(j-1) == '*') {
						if(dp[i][j-2]) {
							dp[i][j] = dp[i][j-2]; // *前面字符出现0次
						} else {
							if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
								dp[i][j] = dp[i-1][j]; // *前面字符出现多次
							}
						}
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

}
