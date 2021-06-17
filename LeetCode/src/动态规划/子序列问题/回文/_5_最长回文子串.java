package 动态规划.子序列问题.回文;

/**
 * @ClassName: _5_最长回文子串
 * @Author: whc
 * @Date: 2021/06/17/12:07
 */
public class _5_最长回文子串 {

	/**
	 * 思路: 动态规划
	 * 1. dp[i][j]表示s[i:j]区间是否是回文子串
	 * 2. 递推公式
	 * 		if(s[i] != s[j]) {
	 * 		 	dp[i][j] = false;
	 * 		} else {
	 * 			// 两个字符时,比如aa,不需要用到递推公式
	 * 			if(j - i <= 1) {
	 * 			 	dp[i][j] = true;
	 * 			} else {
	 * 			    dp[i][j] = dp[i+1][j-1];
	 * 			}
	 * 		}
	 *
	 * 	3. 初始化
	 * 	   i == j时, dp[i][j] = false;
	 *
	 *  4. 遍历顺序
	 *  	从下往上,从左往右
	 *
	 *  5. 举例推导dp数组
	 *     b a b a d
	 *  b  1 0 3 0 0
	 *  a  0 1 0 3 0
	 *  b  0 0 1 0 0
	 *  a  0 0 0 1 0
	 *  d  0 0 0 0 1
	 *
	 *  时间: O(n^2)
	 *  空间: O(n^2)
	 */
	/*public static String longestPalindrome(String s) {
		int len = s.length();

		if(len < 2) {
			return s;
		}

		boolean[][] dp = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}

		int maxLen = 1;
		int start = 0;

		for (int i = len-2; i >= 0; i--) {
			for (int j = i+1; j < len; j++) {
				if(s.charAt(i) != s.charAt(j)) {
					dp[i][j] = false;
				} else {
					// 两个字符相等时,比如aa,不需要用到递推公式
					if(j - i <= 1) {
						dp[i][j] = true;
					} else {
						dp[i][j] = dp[i+1][j-1];
					}
				}

				if(dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					start = i;
				}
			}
		}

		return s.substring(start, start + maxLen);
	}*/

	/**
	 *  思路: 双指针法(中心扩展)
	 *
	 *  1. 在遍历中心节点的时候,往两边扩散看看是不是对称
	 *  2. 中心节点有两种情况:
	 *  	- 一个元素作为中心节点
	 *  	- 两个元素作为中心节点
	 *
	 *  3. 两种情况分别计算
	 *
	 *  时间: O(n^2)
	 *  空间: O(1)
	 */
	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}

		int start = 0;
		int maxLen = 1;

		for (int i = 0; i < s.length(); i++) {
			int len1 = extend(s, i, i);
			int len2 = extend(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len > maxLen) {
				maxLen = len;
				// 如果是cccc, 两个元素作为中心节点开始扩展的话,需要 start - (len -1)/2 , 即1 - (4-1)/2 = 0
				// 如果是ccc, 一个元素作为中心节点开始扩展的话, 也需要 start - (len -1)/2, 即1 - (3-1)/2 = 0;
				start = i - (len -1) / 2;
			}
		}

		return s.substring(start, start + maxLen);
	}

	private int extend(String s, int left, int right) {
		// 比如 a b a
		// left = 1, right = 1
		// 从b开始扩展, 最后返回长度: left = -1, right = 3, right - left - 1 = 3
		// 再比如 a b b a
		// 从b b两个元素开始扩展, 最后返回长度: left = -1, right = 3, right - left - 1 = 3
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
