package 动态规划.子序列问题.回文;

/**
 * @ClassName: _516_最长回文子序列
 * @Author: whc
 * @Date: 2021/06/17/11:17
 */
public class _516_最长回文子序列 {

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数组以及下标含义
	 *    dp[i][j] : 字符串s[i:j]范围内的最长回文子序列的长度为dp[i][j]
	 *
	 * 2. 确定递推公式
	 * 	  // 首尾字符相同
	 * 	  if(s[i] == s[j]) {
	 * 	      dp[i][j] = dp[i+1][j-1] + 2;
	 * 	  } else {
	 * 	      //  分两种情况, 说明s[i]和s[j]不能同时加入, 则分别加入s[i]、s[j]看看哪一个可以组成最长回文子序列
	 * 	      // ①加入s[i]的回文子序列长度为: dp[i][j-1]
	 * 	      // ②加入s[j]的回文子序列长度为: dp[i+1][j]
	 * 	      // 比如 cbbd, 计算dp[0][3]时, s[0] != s[3]
	 * 	      // 不加s[0]时,加入s[3], dp[0][3] = dp[1][3] 即bbd
	 * 	      // 不加s[3]时,加入s[0], dp[0][3] = dp[0][2] 即cbb
	 * 	      dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j])
	 * 	  }
	 *
	 * 	3. 初始化
	 * 		i与j相同时,即指向了同一个字符,此时dp[i][j] = 1, 防止被0覆盖,成为2, 因为1个字符长度只能为1
	 *
	 * 	4. 确定遍历顺序
	 * 		由递推公式可知, 从下往上, 从左往右遍历
	 *
	 *  5. 举例推导dp数组
	 *  比如 s = "cbbd"
	 *
	 *    c b b d
	 *  c 1 1 2 2
 	 *  b 0 1 2 2
	 *  b 0 0 1 1
	 *  d 0 0 0 1
	 *
	 *  时间: O(n^2)
	 *  空间: O(n^2)
	 */
	/*public int longestPalindromeSubseq(String s) {
		int res = 0;
		int len = s.length();
		int[][] dp = new int[len][len];

		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}

		for (int i = len-2; i >= 0; i--) {
			for (int j = i+1; j < len; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}

		return dp[0][len-1];
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n^2)
	// 空间: O(n)
	public int longestPalindromeSubseq(String s) {
		if(s.length() == 1) {
			return 1;
		}

		int res = 0;
		int len = s.length();
		int[] dp = new int[len];

		dp[len-1] = 1;

		int leftBottom = dp[len-2];

		for (int i = len-2; i >= 0; i--) {
			dp[i] = 1;
			for (int j = i+1; j < len; j++) {
				int temp = dp[j];
				if(s.charAt(i) == s.charAt(j)) {
					dp[j] = leftBottom + 2;
				} else {
					dp[j] = Math.max(dp[j-1], dp[j]);
				}
				leftBottom = temp;
			}
			if(i != 0) {
				leftBottom = dp[i-1];
			}
		}

		return dp[len-1];
	}
}
