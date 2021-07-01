package 数组.二分法;

/**
 * @ClassName: _69_x的平方根
 * @Author: whc
 * @Date: 2021/07/01/11:28
 */
public class _69_x的平方根 {

	/**
	 * 思路: 二分法求解
	 * 定义left, right, mid 三个数
	 * 判断mid² 与 x的关系
	 * 1. mid² == x
	 * 	  return mid
	 * 2. mid² > x
	 *    right = mid - 1
	 * 3. mid² < x
	 * 	  left = mid + 1
	 *
	 * 由于mid²会出现整数溢出的情况, 所以用除法代替 mid < x / mid 之类的
	 *
	 */
	public int mySqrt(int x) {
		if(x == 0) {
			return 0;
		}

		if(x == 1) {
			return 1;
		}

		int left = 1;
		int right = x/2;

		while(left <= right) {
			int mid = left + (right - left) / 2;

			// x == mid * mid 会出现整数溢出, 所以改写成 x / mid == mid
			if(x / mid == mid) {
				return mid;
			} else if(x / mid > mid) {
				// x > mid * mid 会出现整数溢出, 所以改写成 x / mid > mid
				left = mid + 1;
			} else {
				// x  < mid * mid 会出现整数溢出, 所以改写成 x / mid < mid
				right = mid - 1;
			}
		}

		return right;
	}

}
