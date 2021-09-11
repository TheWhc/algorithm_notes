package CodeTop;

/**
 * @ClassName: _剑指_Offer_10_II_青蛙跳台阶问题
 * @Author: whc
 * @Date: 2021/09/11/11:16
 */
public class _剑指_Offer_10_II_青蛙跳台阶问题 {

	public int numWays(int n) {
		if(n < 2) {
			return 1;
		}

		int a = 1;
		int b = 2;

		for (int i = 2; i <= n; i++) {
			int sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}

		return a;
	}
}
