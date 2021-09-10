package CodeTop;

/**
 * @ClassName: _44_通配符匹配
 * @Author: whc
 * @Date: 2021/09/10/10:04
 */
public class _44_通配符匹配 {

	/**
	 * 思路：动态规划
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]: 表示s包含下标i在内的子串 是否与 p包含下标j在内的子串匹配
	 *
	 * 2. 确定递推公式
	 * if(p[j] != '*') {
	 *     if(s[i] == p[j] || p[j] == '?') {
	 *         dp[i][j] = dp[i-1][j-1];
	 *     }
	 * } else {
	 *     dp[i][j] = dp[i-1][j] || dp[i][j-1]
	 *                *匹配字符串      *不匹配
	 * }
	 *
	 * 3. 初始化
	 *
	 * 画表格
	 * dp[0][0] = true
	 * dp[i][0] = false
	 *
	 * 第0行时
	 * if(s[0][j] == '*') {
	 *     dp[0][j] = dp[0][j-1];
	 * }
	 *
	 */
	/*public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}

		if(p.length() == 0) {
			return false;
		}

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		dp[0][0] = true;

		for (int j = 1; j < p.length() + 1; j++) {
			if(p.charAt(j-1) == '*') {
				dp[0][j] = dp[0][j-1];
			}
		}

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				if(p.charAt(j-1) != '*') {
					if(p.charAt(j-1) == s.charAt(i-1)|| p.charAt(j-1) == '?') {
						dp[i][j] = dp[i-1][j-1];
					}
				} else {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}

		return dp[s.length()][p.length()];
	}*/


	// 空间优化
	public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}

		if(p.length() == 0) {
			return false;
		}

		boolean[] dp = new boolean[p.length() + 1];

		dp[0] = true;

		for (int j = 1; j < p.length() + 1; j++) {
			if(p.charAt(j-1) == '*') {
				dp[j] = dp[j-1];
			}
		}

		boolean leftUp = dp[0];
		dp[0] = false;
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 1; j < p.length() + 1; j++) {
				boolean tmp = dp[j];
				if(p.charAt(j-1) != '*') {
					if(p.charAt(j-1) == s.charAt(i-1)|| p.charAt(j-1) == '?') {
						dp[j] = leftUp;
					} else {
						dp[j] = false;
					}
				} else {
					dp[j] = dp[j] || dp[j-1];
				}
				leftUp = tmp;
			}

			leftUp = dp[0];
		}

		return dp[p.length()];
	}
}
