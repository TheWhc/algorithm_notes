package 贪心.拆分问题;

/**
 * @ClassName: _343_整数拆分
 * @Author: whc
 * @Date: 2021/06/25/16:09
 */
public class _343_整数拆分 {
	/**
	 * 思路: 贪心法
	 * 每次拆分为3,如果剩余4,则保留4,然后相乘
	 */
	public int integerBreak(int n) {
		if(n == 2) {
			return 1;
		}
		if(n == 3) {
			return 2;
		}
		if(n == 4) {
			return 4;
		}

		int result = 1;
		while(n > 4) {
			result *= 3;
			n -= 3;
		}

		return result * n;
	}

}
