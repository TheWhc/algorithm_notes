package 待分类;

import java.util.List;

/**
 * @ClassName: 待分类._647_回文子串
 * @Author: whc
 * @Date: 2021/03/19/11:13
 */
public class _647_回文子串 {
	// 暴力解法 O(n^3)
	/*public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				int left = i;
				int right = j;
				while(left <= right) {
					if(s.charAt(left) != s.charAt(right)) {
						break;
					} else {
						left++;
						right--;
					}
				}
				if(left == right) {
					res++;
				}
			}
		}
		return res;
	}*/

	// 动态规划 O(n^2)
	/*public int countSubstrings(String s) {
		int result = 0;
		// 1. 确定dp数组及含义 dp[i][j] 代表 字符[i,j]区间 是否为回文
		boolean[][] dp = new boolean[s.length()-1][s.length()-1];
		// 2. 确定递推公式
		// s[i] != s[j] 直接返回false
		// s[i] == s[j] 分为三种情况分析
		// a. i == j 比如 a, 是回文子串 dp[i][j] = true
		// b. j - i = 1 比如 aa, 也是回文字串  dp[i][j] = true
		// c. j - i > 1 比如 aba, 也是回文子串 dp[i][j] = dp[i+1][j-1]

		// 3. 初始化 dp[i][j]初始化为默认false
		// 4. 遍历顺序 (从下到上 从左到右 因为dp[i][j] 由 dp[i+1][j-1]递推过来)
		for (int i = s.length()-1; i >= 0; i--) {
			// 填充右上角 因为j 只能 >= i
			for (int j = i; j < s.length(); j++) {
				if(s.charAt(j) == s.charAt(i)) {
					if(j - i <= 1) {
						result++;
						dp[i][j] = true;
					} else if(dp[i+1][j-1]) {
						result++;
						dp[i][j] = true;
					}
				}
			}
		}

		return result;
	}*/

	// 中心扩展
	public int countSubstrings(String s) {
		int result = 0;
		//一个元素可以作为中心点，两个元素也可以作为中心点。
		for (int i = 0; i < s.length(); i++) {
			result += extend(s, i, i, s.length()); // 以i为中心扩展
			result += extend(s, i, i+1, s.length()); // 以i+1为中心扩展
		}
		return result;
	}

	private int extend(String s, int i, int j, int n) {
		int res = 0;
		while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
			res++;
			i--;
			j++;
		}
		return res;
	}
}
