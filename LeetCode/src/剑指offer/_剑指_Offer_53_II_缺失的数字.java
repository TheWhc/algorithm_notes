package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_53_II_缺失的数字
 * @Author: whc
 * @Date: 2021/04/02/16:32
 */
public class _剑指_Offer_53_II_缺失的数字 {
//	public int missingNumber(int[] nums) {
//		for (int i = 0; i < nums.length; i++) {
//			if(nums[i] != i) {
//				return i;
//			}
//		}
//		return nums.length;
//	}

	// 2021/4/2 二刷
	// 二分查找
//	public int missingNumber(int[] nums) {
//		int left = 0;
//		int right = nums.length - 1;
//		while(left <= right) {
//			int mid = (left + right) >> 1;
//			if(nums[mid] == mid) {
//				// 缺失在后面
//				left = mid + 1;
//			} else {
//				// 缺失在前面
//				right = mid - 1;
//			}
//		}
//		return left;
//	}

	/**
	 * 思路: 二分法
	 *
	 * 1. 如果中间元素的值和下标相等，那么下一轮查找只需要查找右半边；
	 * 2. 如果中间元素的值和下标不相等，那么下一轮就只查找左半边。
	 *
	 * 时间: O(logn)
	 * 空间: O(1)
	 */
	public int missingNumber(int[] nums) {
		int left = 0;
		int rihgt = nums.length-1;
		while(left <= rihgt) {
			int mid = (left + rihgt) / 2;
			if(nums[mid] == mid) {
				left = mid + 1;
			} else {
				rihgt = mid - 1;
			}
		}

		return left;
	}
}
