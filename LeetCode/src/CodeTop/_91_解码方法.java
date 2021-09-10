package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _91_解码方法
 * @Author: whc
 * @Date: 2021/09/10/21:16
 */
public class _91_解码方法 {

	/**
	 * 思路： 递归法
	 *
	 * 例子: 2322233323
	 *
	 * 划分为2|322233323 和 23|22233323
	 *
	 *
	 */

	/*Map<Integer, Integer> map = new HashMap<>();
	public int numDecodings(String s) {
		return getAns(s, 0);
	}

	private int getAns(String s, int start) {
		// 划分到了最后返回1
		if(start == s.length()) {
			return 1;
		}

		// 开头是0
		if(s.charAt(start) == '0') {
			return 0;
		}

		int m = map.getOrDefault(start, -1);
		if(m != -1) {
			return m;
		}

		int ans1 = getAns(s, start+1);
		int ans2 = 0;

		// 判断前两个数字是否小于26
		if(start < s.length()-1) {
			int ten = (s.charAt(start) - '0') * 10;
			int one = s.charAt(start+1) - '0';
			if(ten + one <= 26) {
				ans2 = getAns(s, start+2);
			}
		}

		map.put(start, ans1 + ans2);

		return ans1 + ans2;
	}*/


	/**
	 * 思路：动态规划
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i]:表示下标i到下标s.length()-1的解码方式有几种
	 *
	 * 2. 确定递推公式
	 * dp[i] = dp[i+1] + dp[i+2]
	 * 其中加上dp[i+2]要满足两个数字小于等于26
	 *
	 * 3. 初始化
	 * dp[s.length()] = 1  方便递推
	 * if(s.charAt(s.length()-1) != '0') {
	 * 		dp[s.length()-1] = 1;
	 * }
	 *
	 * 4. 确定遍历顺序
	 * 从递推公式可知,需要从后往前推
	 *
	 */
	public int numDecodings(String s) {
		int[] dp = new int[s.length()+1];
		dp[s.length()] = 1;
		if(s.charAt(s.length()-1) != '0') {
			dp[s.length() - 1] = 1;
		}

		for (int i = s.length()-2; i >= 0; i--) {
			if(s.charAt(i) == '0') {
				continue;
			}
			int ans1 = dp[i+1];
			int ans2 = 0;
			int ten = (s.charAt(i) - '0') * 10;
			int one = s.charAt(i+1) - '0';
			if(ten + one <= 26) {
				ans2 = dp[i+2];
			}
			dp[i] = ans1 + ans2;
		}

		return dp[0];
	}
}
