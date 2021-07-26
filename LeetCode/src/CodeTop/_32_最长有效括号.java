package CodeTop;

/**
 * @ClassName: _32_最长有效括号
 * @Author: whc
 * @Date: 2021/07/26/17:11
 */
public class _32_最长有效括号 {

	// 动态规划
	public int longestValidParentheses(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		// dp[i]表示包含下标i在内的最长有效括号长度
		int[] dp = new int[s.length()];

		/**
		 * 递推公式
		 * 如果s[i]=='(',则dp[i]=0;
		 * 如果s[i]==')',有两种情况:
		 * 	 如果s[i-1] == '(', 则dp[i]=dp[i-2]+2
		 * 	 如果s[i-1] == ')', 则做进一步分析：
		 * 	 	"(  (  (  )  )  )"
		 * 	       	        i-1 i
		 * 	下标  0 	1  2  3  4  5
		 * 	dp值  0 0  0  2  4  6
		 *
		 * 	当i=5时,需要判断s[i-dp[i-1]-1]即上面例子中dp[0]位置的字符是否为'(',如果是,则dp[i]=dp[i-1]+2
		 *
		 * 	如果不是,则dp[i]=0
		 *
		 * 	但是此时还有一种情况,即"()((()))"
		 * 	                          i
		 * 	那么此时dp[i]=dp[i-1]+2还要加上dp[i-dp[i-1]-2]
		 */
		int maxLen = 0;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				dp[i] = 0;
			} else {
				if(s.charAt(i) == '(') {
					dp[i] = dp[i-2] + 2;
				} else {
					if(i - dp[i-1] - 1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
						dp[i] = dp[i-1] + 2 + (i - dp[i-1] - 2 >= 0 ? dp[i-dp[i-1]-2] : 0);
					} else {
						dp[i] = 0;
					}
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}

		return maxLen;
	}
}
