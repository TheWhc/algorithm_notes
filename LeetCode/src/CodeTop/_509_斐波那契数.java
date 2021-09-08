package CodeTop;

/**
 * @ClassName: _509_斐波那契数
 * @Author: whc
 * @Date: 2021/09/08/22:13
 */
public class _509_斐波那契数 {

	public int fib(int n) {
		if(n <= 1) {
			return n;
		}
		int a = 1;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int sum = a + b;
			a = b;
			b = sum;
		}

		return b;
	}
}
