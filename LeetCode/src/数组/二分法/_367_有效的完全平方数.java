package 数组.二分法;

/**
 * @ClassName: _367_有效的完全平方数
 * @Author: whc
 * @Date: 2021/07/01/13:22
 */
public class _367_有效的完全平方数 {

	/**
	 * 思路: 二分法求解
	 * 定义left, right, mid 三个数
	 * 判断mid² 与 x的关系
	 * 1. mid² == num
	 * 	  return mid
	 * 2. mid² > num
	 *    right = mid - 1
	 * 3. mid² < num
	 * 	  left = mid + 1
	 *
	 * 由于mid²会出现整数溢出的情况, 所以用除法代替 mid < num*1.0 / mid 之类的
	 *
	 */
	public boolean isPerfectSquare(int num) {

		// 特殊情况
		if(num == 1) {
			return true;
		}

		int left = 1;
		// 减少运算, 如果num=1需要单独判断
		int right = num/2;

		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(mid == num * 1.0 / mid) {
				// mid * mid  == num
				return true;
			} else if(mid > num * 1.0 / mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return false;
	}
}
