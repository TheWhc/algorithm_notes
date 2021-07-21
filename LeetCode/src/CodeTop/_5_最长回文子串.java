package CodeTop;

/**
 * @ClassName: _5_最长回文子串
 * @Author: whc
 * @Date: 2021/07/21/11:10
 */
public class _5_最长回文子串 {

	// 动态规划
	/*public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];

		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = true;
		}

		int maxLen = 1; // 最长回文子串的长度
		int start = 0; // 最长回文子串起始位置

		// 从下到上,从左到右
		for (int i = s.length()-2; i >= 0; i--) {
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(j - i <= 1) {
						// 比如"aa"
						dp[i][j] = true;
					} else {
						// 收缩
						dp[i][j] = dp[i+1][j-1];
					}
				}

				if(dp[i][j] && (j - i + 1) > maxLen) {
					maxLen = j - i + 1;
					start = i;
				}
			}
		}

		return s.substring(start, start + maxLen);
	}*/

	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}

		int maxLen = 1;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = extend(s, i, i); // 一个元素扩展
			int len2 = extend(s, i, i+1); // 两个元素扩展

			int len = Math.max(len1, len2);
			if(len > maxLen) {
				maxLen = len;
				start = i - (len - 1) / 2;
			}
		}

		return s.substring(start, start + maxLen);
	}

	private int extend(String s, int left, int right) {

		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}
}
