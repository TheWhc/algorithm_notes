package CodeTop;

/**
 * @ClassName: _50_Pow_x_n
 * @Author: whc
 * @Date: 2021/08/21/23:21
 */
public class _50_Pow_x_n {

	// 快速幂
	// https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-de-ji-chu-zhi-shi-d-z7ny/

	/**
	 * 例子: 3^10
	 * 10 % 2 == 0
	 * 10 / 2 = 5
	 * = 3^5 * 3^5
	 *
	 * 此时y=5时,那么
	 * 5 % 2 != 0
	 * 5 / 2 = 2
	 * = 3^2 * 3^2 * 3
	 */
	/*public double myPow(double x, int n) {
		long N = n;
		return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
	}

	// 注意这里为long,因为如果是求最小值的负次方,那么相反数会超过Integer.MAX_VALUE
	private double quickPow(double x, long y) {
		if(y == 0) {
			return 1;
		}

		double res = quickPow(x, y / 2);

		return y % 2 == 0 ? res * res : res * res * x;
	}
*/

	public double myPow(double x, int n) {
		long N = n;
		return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
	}

	public double quickPow(double x, long y) {
		double ret = 1.0;
		while(y != 0){
			if((y & 1) != 0) {
				ret = ret * x;
			}
			x = x * x;
			y >>= 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		_50_Pow_x_n _50_Pow_x_n = new _50_Pow_x_n();
		_50_Pow_x_n.myPow(3, 10);
	}

}
