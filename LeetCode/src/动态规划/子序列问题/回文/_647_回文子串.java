package 动态规划.子序列问题.回文;

/**
 * @ClassName: _647_回文子串
 * @Author: whc
 * @Date: 2021/06/16/13:36
 */
public class _647_回文子串 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]: s[i:j]区间范围内是否为回文子串,如果是dp[i][j]为true,如果不是dp[i][j]=false
	 *  2. 确定递推公式
	 *  	if(s[i] != s[j]) {
	 *  	 	dp[i][j] = false;
	 *  	} else {
	 *  		// s[i] == s[j]时
	 *  	 	// 分三种情况
	 *  	 	// ①i和j下标相同,即同一个字符,单个字符组成,例如a, 则为true
	 *  	 	// ②i和j相差为1,由2个字符组成,且字符要相同,比如aa, 则为true(不需要用到递推公式)
	 *  	 	// ③i和j相差大于1的时候,例如cabac,此时s[i]和s[j]首尾字符已经相同, 需要进一步判断s[i+1:j-1]区间是否是回文子串,即判断dp[i+1][j-1]是否是回文子串(状态转移方程)
	 *  	 	if(j-i <= 1) {
	 *  	 	  	dp[i][j] = true;
	 *  	 	} else {
	 *  	 	  	dp[i][j] = dp[i+1][j-1];
	 *  	 	}
	 *  	}
	 *
	 *  3. 初始化
	 *  	一开始都为false
	 *  4. 遍历顺序
	 *  	由递推公式知
	 *			|            |dp[i][j]|
	 *			|dp[i+1][j-1]|		  |
	 *		所以矩阵应该是从下往上遍历, 从左向右遍历（保证每个dp[i+1][j-1]都是经过计算的）
	 *
	 *  5. 举例推导dp数组
	 *  	"aaa"
	 *       0  1  2
	 *       a  a  a
	 *  0 a	 T	T  T
	 *  1 a     T  T
	 *  2 a        T
	 *  统计有6个T即为答案
	 *
	 *  时间: O(n^2)
	 *  空间: O(n^2)
	 */
	/*public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int res = 0;
		boolean[][] dp = new boolean[len][len];
		for (int i = len-1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if(s.charAt(i) != s.charAt(j)) {
					continue;
				} else {
					if(j - i <= 1) {
						dp[i][j] = true;
						res++;
					} else {
						if(dp[i+1][j-1]) {
							dp[i][j] = true;
							res++;
						}
					}
				}
			}
		}

		return res;
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n^2) 空间:O(n)
	/*public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int res = 0;
		boolean[] dp = new boolean[len];
		boolean leftBottom = dp[len-1];
		for (int i = len-1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				boolean temp = dp[j];
				if(s.charAt(i) != s.charAt(j)) {
					dp[j] = false;
				} else {
					if(j - i <= 1) {
						dp[j] = true;
						res++;
					} else {
						if(leftBottom) {
							dp[j] = true;
							res++;
						} else {
							dp[j] = false;
						}
					}
				}
				leftBottom = temp;
			}
			leftBottom = dp[i];
		}

		return res;
	}*/


	/**
	 *  思路: 双指针法(中心扩展)
	 *  1. 在遍历中心节点的时候,往两边扩散看是不是对称即可
	 *  2. 中心节点有两种情况:
	 *  	- 一个元素作为中心节点
	 *  	- 两个元素作为中心节点
	 *  	比如ababa
	 *  	a可以作为中心节点进行扩展,但是这样就无法得到abab,所以同样也要有两个元素作为中心节点
	 *  	ab作为中心节点,就可以得到abab了
	 *
	 *  3. 两种情况可以放在一起计算,或者分别计算,这里给出的是分别计算
	 *
	 *  时间: O(n^2)
	 *  空间: O(1)
	 *
	 */
	public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			// 一个元素作为中心节点
			res += extend(s, i, i);
			// 两个元素作为中心节点
			res += extend(s, i, i+1);
		}
		return res;
	}

	private int extend(String s, int left, int right) {
		int sum = 0;
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			sum++;
			left--;
			right++;
		}
		return sum;
	}
}
