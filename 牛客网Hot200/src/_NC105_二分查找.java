/**
 * @ClassName: _NC105_二分查找
 * @Author: whc
 * @Date: 2021/01/27/11:37
 */
public class _NC105_二分查找 {
	/**
	 * 二分查找
	 * @param n int整型 数组长度
	 * @param v int整型 查找值
	 * @param a int整型一维数组 有序数组
	 * @return int整型
	 */
	public int upper_bound_ (int n, int v, int[] a) {
		// write code here
		int left = 0;
		int right = n-1;
		while(left < right) {
			int mid = (left + right) >> 1;
			if(a[mid] > v) {
				right = mid-1;
			} else if(a[mid] < v) {
				left = mid+1;
			} else {
				return mid+1;
			}
		}

		return n+1;
	}
}
