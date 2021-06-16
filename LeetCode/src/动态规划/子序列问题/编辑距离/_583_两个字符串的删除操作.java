package 动态规划.子序列问题.编辑距离;

/**
 * @ClassName: _583_两个字符串的删除操作
 * @Author: whc
 * @Date: 2021/06/16/11:32
 */
public class _583_两个字符串的删除操作 {

	/**
	 *  思路: 动态规划
	 *
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]:表示word1[i]和word2[j]达到相等,所需要删除元素的最少次数
	 *  2. 确定递推公式
	 *  	if(word1[i] == word2[j]) {
	 *  	 	dp[i][j] = dp[i-1][j-1];
	 *  	} else {
	 *  	 	// 分三种情况
	 *  	 	// ① 删word1[i],最少操作数 = dp[i-1][j] + 1
	 *  	 	// ② 删word2[j],最少操作数 = dp[i][j-1] + 1
	 *  	 	// ③ 同时删word1[i]和word2[j],最少操作数 = dp[i-1][j-1] + 2
	 *  	 	dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1),dp[i-1][j-1]+2);
	 *  	}
	 *  3. 初始化
	 *  	dp[0][j] = j;
	 *  	dp[i][0] = i;
	 *  4. 遍历顺序
	 *  	先遍历word1,后遍历word2
	 *
	 *  5. 举例推导dp数组
	 *  	比如"sea"和"eat"
	 *      e a t
	 *    0 1 2 3
	 *  s 1 2 3 4
	 *  e 2 1 2 3
	 *  a 3 2 1 2
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 */
	/*public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[][] dp = new int[n+1][m+1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= m; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1),dp[i-1][j-1]+2);
				}
			}
		}

		return dp[n][m];
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n*m)
	// 空间: O(m)
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[] dp = new int[m+1];

		for (int i = 0; i <= m; i++) {
			dp[i] = i;
		}

		int leftUp = dp[0];

		for (int i = 1; i <= n; i++) {
			dp[0] = i;
			for (int j = 1; j <= m; j++) {
				int temp = dp[j];
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[j] = leftUp;
				} else {
					dp[j] = Math.min(Math.min(dp[j]+1, dp[j-1]+1),leftUp+2);
				}
				leftUp = temp;
			}
			leftUp = dp[0];
		}

		return dp[m];
	}
}
