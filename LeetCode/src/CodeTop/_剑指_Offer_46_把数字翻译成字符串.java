package CodeTop;

/**
 * @ClassName: _剑指_Offer_46_把数字翻译成字符串
 * @Author: whc
 * @Date: 2021/09/13/22:07
 */
public class _剑指_Offer_46_把数字翻译成字符串 {

	/**
	 * 思路： 动态规划
	 */
	/*public int translateNum(int num) {
		String strNum = String.valueOf(num);
		// dp[i]表示以Xi结尾的数字的翻译方案数量
		int[] dp = new int[strNum.length()+1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			int ans = (strNum.charAt(i-2) - '0') * 10 + (strNum.charAt(i-1) - '0');
			if(ans >= 10 && ans <= 25) {
				dp[i] = dp[i-1] + dp[i-2];
			} else {
				dp[i] = dp[i-1];
			}
		}

		return dp[dp.length-1];
	}*/

	// 优化
	public int translateNum(int num) {
		String strNum = String.valueOf(num);
		// dp[i]表示以Xi结尾的数字的翻译方案数量

		int a = 1;
		int b = 1;

		for (int i = 2; i < strNum.length() + 1; i++) {
			int ans = (strNum.charAt(i-2) - '0') * 10 + (strNum.charAt(i-1) - '0');
			if(ans >= 10 && ans <= 25) {
				int sum = a + b;
				a = b;
				b = sum;
			} else {
				a = b;
			}
		}

		return b;
	}
}
