package 剑指offer;

/**
 * @ClassName: _剑指_Offer_46_把数字翻译成字符串
 * @Author: whc
 * @Date: 2021/06/02/9:58
 */
public class _剑指_Offer_46_把数字翻译成字符串 {

	/**
	 *  思路: 动态规划
	 *
	 *  x1x2....X(i-2) X(i-1) Xi ..... X(n-1) Xn
	 *  比如 123
	 *  递推公式: 如果X(i-1)和Xi可翻译,即整体被翻译,那么dp[i] = dp[i-2]
	 *           如果Xi单独翻译,那么dp[i] = dp[i-1]
	 *           所以综上,当Xi-1Xi能够被翻译时, dp[i] = dp[i-1] + dp[i-2],
	 *           如果Xi-1Xi不能被翻译时(比如04、05、26、27等不满足条件的两位数),dp[i] = dp[i-1]
	 *
	 *  初始化时, dp[0] = 1, dp[1] = 1(一个数字时只有一种翻译方法)
	 *  dp[0] = 1是为了推导dp[2]
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public int translateNum(int num) {
		String s = String.valueOf(num);

		// dp[i]表示以Xi为结尾的数字的翻译方案数量
		int[] dp = new int[s.length() + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			int curSum = Integer.valueOf(s.charAt(i-2) - '0') * 10 + Integer.valueOf(s.charAt(i-1) - '0');
			if(curSum >= 10 && curSum <= 25) {
				dp[i] = dp[i-1] + dp[i-2];
			} else {
				dp[i] = dp[i-1];
			}
		}

		return dp[s.length()];
	}*/


	// 空间优化
	public int translateNum(int num) {
		String s = String.valueOf(num);

		int a = 1;
		int b = 1;

		for (int i = 2; i <= s.length(); i++) {
			int curSum = Integer.valueOf(s.charAt(i-2) - '0') * 10 + Integer.valueOf(s.charAt(i-1) - '0');
			int sum = 0;
			if(curSum >= 10 && curSum <= 25) {
				sum = a + b;
			} else {
				sum = b;
			}
			a = b;
			b = sum;
		}

		return b;
	}
}
