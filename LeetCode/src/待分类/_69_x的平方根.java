package 待分类;

/**
 * @ClassName: 待分类._69_x的平方根
 * @Author: whc
 * @Date: 2021/03/18/0:08
 */
public class _69_x的平方根 {

	// 二分法
	public int mySqrt(int x) {
		long left = 0;
		// 照顾1 把右边界设置为x // 2 + 1;
		long right = x / 2 + 1;
		while(left < right) {
			// 取右中位数,左中位数代码会进入死循环
			long mid = left + (right - left + 1) / 2;
			long square = mid * mid;
			if(square > x) {
				right = mid-1;
			} else {
				left = mid;
			}
		}

		return (int)left;
	}

}
