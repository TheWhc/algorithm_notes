package 动态规划.子序列问题.编辑距离;

/**
 * @ClassName: _115_不同的子序列
 * @Author: whc
 * @Date: 2021/06/16/11:13
 */
public class _115_不同的子序列 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j] : 以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
	 *  2. 确定递推公式
	 *  	if(s[i] == t[j]) {
	 *  		dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
	 *  		// dp[i-1][j-1]表示匹配s[i]和t[j], dp[i-1][j]表示不匹配s[i]和t[j]
	 *  		// 比如baegg 和 bag, 求dp[5][3]时, 匹配最后一个字符,s可以组成bag, 不匹配最后一个字符,s也可以组成bag
	 *  	} else {
	 *  	 	dp[i][j] = dp[i-1][j];
	 *  	}
	 *
	 *  3. 确定遍历顺序
	 *  	外层遍历s,内层遍历t
	 *
	 *  4. 初始化
	 *  	i=0时, 除了dp[0][0]外, dp[0][j]一定都为0, 因为空字符串s无论如何都无法组成t
	 *  	j=0时, dp[i][0]一定都为1, 因为字符串s可以删除全部字符,组成空字符串t
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 */
	/*public int numDistinct(String s, String t) {
		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n+1][m+1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][m];
	}*/

	// 动态规划 + 空间压缩
	// 时间: O(n * m)
	// 空间: O(m)
	public int numDistinct(String s, String t) {
		int n = s.length();
		int m = t.length();

		int[] dp = new int[m+1];

		dp[0] = 1;
		int leftUp = dp[0];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int temp = dp[j];
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[j] = leftUp + dp[j];
				}
				leftUp = temp;
			}
			leftUp = dp[0];
		}

		return dp[m];
	}
}
