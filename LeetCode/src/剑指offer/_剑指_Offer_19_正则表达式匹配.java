package 剑指offer;

/**
 * @ClassName: _剑指_Offer_19_正则表达式匹配
 * @Author: whc
 * @Date: 2021/05/26/11:05
 */
public class _剑指_Offer_19_正则表达式匹配 {

	/**
	 *  思路: 动态规划
	 *  1. dp[i][j]:表示s的前i个和p的前j个是否匹配
	 *  2. 手动求二维矩阵的每个值,通过计算可以发现:
	 *  	- 第0列,除了dp[0][0]=true,其余dp[i][0]=false
	 *  	- s从0开始算,p从1开始算
	 *  	- 过程中考虑dp[i][j]由哪个值得来
	 *  3. 需要考虑p的当前字符p[j]
	 *  	a. 当前字符是字母
	 *  	b. 当前字符是'.'
	 * 			由a和b判断两个字符是否匹配
	 * 			字符匹配: s[i] == p[j] || p[j] == '.'
	 * 			字符不匹配: s[i] != p[j]
 * 		   c. 当前字符是'*'
	 * 		   	'*'表示前面字符可以出现0次或者出现多次
	 * 		   	（注意j从2开始）
	 * 		   	前面字符与s[i]匹配时,则使用'*': 代表前面字符出现一次或者多次: s当前位置可以由s的前i-1和p的前j个是否可以匹配,即dp[i][j] = dp[i-1][j]
	 * 		   	前面字符与s[i]不匹配时,则不使用'*': 代表前面字符出现0次: s当前位置可以由s的前i和p的前j-2个是否可以匹配,即dp[i][j] = dp[i][j-2]
	 * 4. 初始化
	 * 	  dp[0][0] = true
	 * 	  初始化第0行,为了后面方便计算,所以当遇到'*'且j>=2时,则dp[0][j] = dp[0][j-2]
	 * 	  因为*前面的字符可以出现0次或者多次,匹配第一行,s为空,所以这里出现0次的话,则匹配j-2就可以
	 *
	 * 时间: O(n*m)
	 * 空间: O(n*m)
	 */
	public static boolean isMatch(String s, String p) {
		if(s == null && p == null) {
			return true;
		}
		if(p == null) {
			return false;
		}
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];

		// 初始化
		dp[0][0] = true;
		for (int j = 2; j <= n; j++) {
			if(p.charAt(j-1) == '*') {
				dp[0][j] = dp[0][j-2];
			}
		}

		for (int i = 1; i <= m; i++) {
			char charS = s.charAt(i-1);
			for (int j = 1; j <= n; j++) {
				char charP = p.charAt(j-1);
				if(charP != '*') {
					if(charS == charP || charP == '.') {
						dp[i][j] = dp[i-1][j-1];
					}
				} else {
					// 不使用'*': 代表前面字符出现0次
					if(j >= 2) {
						dp[i][j] = dp[i][j-2];
					}
					// 使用'*': 代表当前位置s[i]匹配一次,然后匹配剩余的s[i-1]是否与p[j]匹配即可
					if(j >= 2 && (charS == p.charAt(j-2) || p.charAt(j-2) == '.')) {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}

		for (int i = 0; i < s.length()+1; i++) {
			for (int j = 0; j < p.length()+1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[m][n];
	}

}
