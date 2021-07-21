package 二分法.二分答案;

/**
 * @ClassName: _69_x的平方根
 * @Author: whc
 * @Date: 2021/07/21/18:12
 */
public class _69_x的平方根 {

	public int mySqrt(int x) {
		if(x == 0) {
			return 0;
		}

		if(x == 1) {
			return 1;
		}

		int left = 1;
		int right = x/2;

		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(mid > x / mid) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return left;
	}
}
