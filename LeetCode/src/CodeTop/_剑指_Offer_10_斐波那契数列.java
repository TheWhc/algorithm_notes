package CodeTop;

/**
 * @ClassName: _剑指_Offer_10_斐波那契数列
 * @Author: whc
 * @Date: 2021/07/26/10:50
 */
public class _剑指_Offer_10_斐波那契数列 {

	public int fib(int n) {
		if(n == 0) {
			return 0;
		}
		int a = 0;
		int b = 1;

		for (int i = 2; i <= n; i++) {
			int sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}

		return b;
	}
}
