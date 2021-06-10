package 剑指offer;

/**
 * @ClassName: _44_通配符匹配
 * @Author: whc
 * @Date: 2021/05/26/13:22
 */
public class _44_通配符匹配 {

	/**
	 * 思路: 动态规划（匹配问题、最长公共子串都可以用动态规划）
	 * 1. dp[i][j] : s的前i个能否被p的前j个匹配
	 * 2. 手动求二维矩阵的每个值,通过计算可以发现:
	 * 		- 第0列,除了dp[0][0]=true,其它的dp[i][0] = false
	 * 	 	- s从0开始算,p从1开始算
	 * 	 	- 过程中考虑dp[i][j]由哪个值得来
	 * 3. 需要考虑p的当前字符p[j]:
	 * 		a. 当前字符是字母
	 * 		b. 当前字符是'?'
	 * 		   由a和b判断两个字符是否匹配
	 * 		   字符匹配: s[i] == p[j] || p[j] == '?'
	 *         字符不匹配: s[i] != p[j]
 *          c. 当前字符是'*'
	 *         '*'可构造一切
	 *         使用'*': 代表一个字符串: s的当前位置可以由'*'代替,所以看s的前i-1和p的前j个是否可以匹配,即dp[i][j] = dp[i-1][j]
	 *         不使用'*': 代表空字符:   s的当前真假取决于s前i个,p的前j-1个,即dp[i][j] = dp[i][j-1]
 *
	 *
	 *     综上a,b,c条件
	 *     字符是字母或'?'时: 匹配时dp[i][j] = dp[i-1][j-1],不匹配时dp[i][j] = false
	 *     字符是'*'时: dp[i][j] = dp[i-1][j] || dp[i][j-1]
	 *
	 * 	时间: O(n*m)
	 * 	空间: O(n*m)
	 */
	/*public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}
		if(p.length() == 0) {
			return false;
		}
		// 1. 定义dp数组
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m+1][n+1];

		// 2. 初始化  dp[i][0]=false
		dp[0][0] = true;

		// 为了处理边界,初始化0行
		for (int j = 1; j <= n; j++) {
			if(p.charAt(j-1) == '*') {
				// 取决于上一个
				dp[0][j] = dp[0][j-1];
			}
			// 不是'*'为false
		}

		// 3. 确定遍历顺序,先遍历s,后遍历p
		for (int i = 1; i <= m; i++) {
			char charS = s.charAt(i-1);
			for (int j = 1; j <= n; j++) {
				char charP = p.charAt(j - 1);
				if(charP != '*') {
					// p当前字符是字母或者?时
					// s和p匹配时取决于dp[i-1][j-1],不匹配为false
					if(charP == charS || charP == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					}
				} else {
					// p字符是'*'时
					// 可以代表一个字符串或者代表空字符
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[m][n];
	}*/


	/**
	 *  思路: 动态规划 + 矩阵压缩为一维空间
	 *  记录leftUp值,在更新dp[j]时,需要记录下原来的leftUp值
	 *  时间: O(n*m)
	 *  空间: O(n)
	 */
	public boolean isMatch(String s, String p) {
		if(s.length() == 0 && p.length() == 0) {
			return true;
		}
		if(p.length() == 0) {
			return false;
		}
		// 1. 定义dp数组
		int m = s.length();
		int n = p.length();
		boolean[] dp = new boolean[n+1];

		// 2. 初始化  dp[i][0]=false
		dp[0] = true;

		// 为了处理边界,初始化0行
		for (int j = 1; j <= n; j++) {
			if(p.charAt(j-1) == '*') {
				// 取决于上一个
				dp[j] = dp[j-1];
			}
			// 不是'*'为false
		}

		boolean leftUp = dp[0];
		dp[0] = false;
		// 3. 确定遍历顺序,先遍历s,后遍历p
		for (int i = 1; i <= m; i++) {
			char charS = s.charAt(i-1);
			for (int j = 1; j <= n; j++) {
				char charP = p.charAt(j - 1);
				if(charP != '*') {
					// p当前字符是字母或者?时
					// s和p匹配时取决于dp[i-1][j-1],不匹配为false
					if(charP == charS || charP == '?') {
						// 字符相等时,需要从左上角推出,所以需要一个临时变量存储当前位置的值
						boolean temp = dp[j];
						dp[j] = leftUp;
						leftUp = temp;
					} else {
						leftUp = dp[j];
						dp[j] = false;
					}
				} else {
					// p字符是'*'时
					// 可以代表一个字符串或者代表空字符
					// 从左或上推出
					leftUp = dp[j];
					dp[j] = dp[j-1] || dp[j];
				}
			}
			// 注意:每结束一行,leftUp值为上一行的最末尾,所以需要更新为dp[0]
			leftUp = dp[0];

			/*System.out.println(leftUp);
			for (int j = 0; j <= n; j++) {
				System.out.print(dp[j] + " ");
			}
			System.out.println();*/
		}
		return dp[n];
	}

	public static void main(String[] args) {
		_44_通配符匹配 a = new _44_通配符匹配();
	}
}
