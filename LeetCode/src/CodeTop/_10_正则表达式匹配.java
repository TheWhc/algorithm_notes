package CodeTop;

/**
 * @ClassName: _10_正则表达式匹配
 * @Author: whc
 * @Date: 2021/09/10/0:28
 */
public class _10_正则表达式匹配 {

	/**
	 * 思路： 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]表示s包含下标i在内的子串和p包含下标j在内的子串是否匹配
	 *
	 * 2. 确定递推公式
	 *
	 * if(p[j] != '*') {
	 *     if(p[j] == '.' || s[i] == p[j]) {
	 *         dp[i][j] = dp[i-1][j-1];
	 *     }
	 * } else {
	 * 注意j从2开始
	 *     if(p[j-1] == s[i]) {
	 *         dp[i][j] = dp[i-1][j];
	 *     } else {
	 *         dp[i][j] = dp[i][j-2];
	 *     }
	 * }
	 *
	 * 3. 初始化
	 * dp[0][0] = true
	 * j从2开始
	 *
	 * for(int j = 2; j < p.length+1; j++) {
	 *     if(p[j] == '*') {
	 *         dp[0][j] = dp[0][j-2];
	 *     }
	 * }
	 */
	public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}

		if(p.length() == 0) {
			return false;
		}

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		dp[0][0] = true;
		for (int j = 2; j < p.length() + 1; j++) {
			if(p.charAt(j-1) == '*') {
				dp[0][j] = dp[0][j-2];
			}
		}

		for (int i = 1; i < s.length()+1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				if(p.charAt(j-1) != '*') {
					if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
						dp[i][j] = dp[i-1][j-1];
					}
				} else {
					// j从2开始,并且当前字符是'*'
					if(j >= 2) {
						// 前面字符匹配0次
						dp[i][j] = dp[i][j - 2];
						// 前面字符匹配一次,注意是或运算
						if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
							dp[i][j] |= dp[i - 1][j];
						}
					}
				}
			}
		}

		return dp[s.length()][p.length()];
	}
}
