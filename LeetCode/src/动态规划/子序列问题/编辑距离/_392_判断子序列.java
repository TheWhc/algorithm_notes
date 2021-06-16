package 动态规划.子序列问题.编辑距离;

/**
 * @ClassName: _392_判断子序列
 * @Author: whc
 * @Date: 2021/06/16/9:38
 */
public class _392_判断子序列 {

	/**
	 *	思路: 双指针法
	 *  1. 指针i指向s, 指向j指向t
	 *  2. 不断移动指针j,一直遍历到结束,除非i指针已到达s末尾
	 *  3. 若指针i和指针j指向的字符匹配时,则i++
	 *
	 *  时间: O(n+m)
	 *  空间: O(1)
	 */
	public boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();

		int i = 0;
		int j = 0;

		while(i < n && j < m) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
			}
			if(i == s.length()) {
				break;
			}
			j++;
		}

		return i == n;
	}

	/**
	 *  思路: 动态规划
	 *  1. dp[i][j]: 表示s包含下标i在内的子串和t包含下标j在内的子串的相同子序列长度
	 *  2. if(s[i] == t[j]) {
	 *     	   dp[i][j] = dp[i-1][j-1] + 1;
	 *     } else {
	 *     		// 不匹配时,相当于t要删除元素,继续匹配
	 *         dp[i][j] = dp[i][j-1];
	 *     }
	 *  3. dp[0][j] = 0, dp[i][0] = 0
	 *  4. 外层遍历s,内层遍历t
	 *
	 *  时间: O(n * m)
	 *  空间: O(n * m)
	 */
	/*public boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}

		return dp[n][m] == n;
	}*/

}
