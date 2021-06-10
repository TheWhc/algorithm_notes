package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_10_I_斐波那契数列
 * @Author: whc
 * @Date: 2021/04/02/18:49
 */
public class _剑指_Offer_10_I_斐波那契数列 {

	public int fib(int n) {
		if(n < 2) {
			return n;
		}
		int a = 0;
		int b = 1;
		for(int i = 2; i <= n; i++) {
			int sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return b;
	}
}
