package CodeTop;

/**
 * @ClassName: _647_回文子串
 * @Author: whc
 * @Date: 2021/09/25/11:35
 */
public class _647_回文子串 {

	/**
	 * 思路: 动态规划
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]表示区间s[i:j]是否为回文子串
	 *
	 * 2. 确定递推公式
	 * s[i] != s[j], 则dp[i][j]=false
	 *
	 * s[i] == s[j], 分三种情况:
	 * 2.1   i == j, 则dp[i][j] = true     比如"a"
	 * 2.2   j - i == 1, 则dp[i][j] = true, 比如"aa"
	 * 2.3   j - i > 1, 则dp[i][j] = dp[i+1][j-1], 比如"c b a a b c"
	 * 												   i          j
	 *
	 * 3. 确定遍历顺序
	 *
	 * 由递推公式可以看出
	 *
	 * |            | dp[i][j] |
	 * |dp[i+1][j-1]|          |
	 *
	 * 从下往上,从左往右递推
	 *
	 * 4. 初始化
	 * 一开始都默认为false
	 *
	 * 5. 举例推导
	 *     0 1 2
	 *     a a a
	 * 0 a T T T
	 * 1 a   T T
	 * 2 a     T
	 */
	/*public int countSubstrings(String s) {
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		int res = 0;
		for (int i = n -1 ; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if(s.charAt(i) != s.charAt(j)) {
					continue;
				} else {
					if(j - i <= 1) {
						dp[i][j] = true;
						res++;
					} else {
						dp[i][j] = dp[i+1][j-1];
						if(dp[i][j]) {
							res++;
						}
					}
				}
			}
		}
		return res;
	}*/

	/**
	 * 思路: 双指针法(中心扩展法)
	 *
	 * 1. 遍历中心节点的时候,往两边扩散看是不是对称
	 * 2. 中心节点有两种情况:
	 * 		- 一个元素作为中间节点
	 * 		- 两个元素作为中间节点
	 */
	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += extend(s, i, i); // 一个元素
			res += extend(s, i, i + 1); // 两个元素
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
