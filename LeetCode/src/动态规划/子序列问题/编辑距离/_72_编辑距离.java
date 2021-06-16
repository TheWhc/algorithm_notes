package 动态规划.子序列问题.编辑距离;

/**
 * @ClassName: _72_编辑距离
 * @Author: whc
 * @Date: 2021/06/16/13:15
 */
public class _72_编辑距离 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]表示word1[i]和word2[j]所需的最少操作数
	 *  2. 确定递推公式
	 *  	if(word1[i] == word2[j]) {
	 *  	 	dp[i][j] = dp[i-1][j-1];
	 *  	} else {
	 *  	 // 分三种情况,增删改操作
	 *  	 // 增加情况, 可以是word1添加一个元素,使word1[i] == word2[j], 即dp[i][j] = dp[i-1][j] + 1
	 *  	 			也可以是word2添加一个元素,使word2[j] == word1[i], 即dp[i][j] = dp[i][j-1] + 1
	 *  	 // 删除情况, 添加元素本身就已经包含删除的情况了,比如word2添加一个元素,相当于word1删除一个元素
	 *  	 // 比如 word1="ad", word2="a", word1删除"d",word2添加一个元素"d",最后变成word1="a",word2="ad", 最终的操作数是一样的
	 *  	 			dp数组如下所示
	 *               a                a  d
 	 *  	      0  1              0 1  2
	 *  	    a 1  0    =====>  a 1 0  1
	 *  	    d 2  1
	 *
	 *  	    dp[2][1]   ==   dp[1][2]
	 *
	 *  	 // 更改情况, wrod1[i]更改成与word2[j]相同的字符, dp[i][j] = dp[i-1][j-1] + 1
	 *
	 *  	 综上, dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+1)
	 *  	}
	 *
	 *  3. 初始化
	 *  	i=0时, dp[0][j] = j;
	 *  	j=0时, dp[i][0]	= i;
	 *
	 *  4. 遍历顺序
	 *  	外层遍历word1,内层遍历word2
	 *
	 *  5. 举例推导dp数组
	 *  	word1="horse", word2="ros"
	 *   	r o s
	 *    0 1 2 3
	 *  h 1 1 2 3
	 *  o 2 2 1 2
	 *  r 3 2 2 3
	 *  s 4 3 3 2
	 *  e 5 4 4 3
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
					dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+1);
				}
			}
		}

		return dp[n][m];
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n*m) 空间: O(m)
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[] dp = new int[m+1];

		for (int j = 0; j <= m; j++) {
			dp[j] = j;
		}

		int leftUp = dp[0];

		for (int i = 1; i <= n; i++) {
			dp[0] = i;
			for (int j = 1; j <= m; j++) {
				int temp = dp[j];
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[j] = leftUp;
				} else {
					dp[j] = Math.min(Math.min(dp[j]+1, dp[j-1]+1), leftUp+1);
				}
				leftUp = temp;
			}
			leftUp = dp[0];
		}

		return dp[m];
	}
}
