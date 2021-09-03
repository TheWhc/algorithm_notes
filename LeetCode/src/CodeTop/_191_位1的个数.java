package CodeTop;

/**
 * @ClassName: _191_位1的个数
 * @Author: whc
 * @Date: 2021/09/03/23:31
 */
public class _191_位1的个数 {

	public int hammingWeight(int n) {
		int res = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				res++;
			}
			n >>>= 1;
		}

		return res;
	}
}
