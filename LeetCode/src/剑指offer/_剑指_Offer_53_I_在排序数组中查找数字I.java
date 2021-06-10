package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_53_I_在排序数组中查找数字I
 * @Author: whc
 * @Date: 2021/04/02/15:00
 */
public class _剑指_Offer_53_I_在排序数组中查找数字I {

	/**
	 *  思路: 二分法
	 *
	 *  1. 通过二分法找到右边界j
	 *  	其中nums[mid] == target时, left = mid + 1
	 *  2. 通过二分法找到左边界i
	 *  	其中nums[mid] == target时, right = mid - 1;
	 *  3. 返回结果j - i - 1
	 *
	 *  时间: O(logn)
	 *  空间: O(1)
	 */
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		// 1. 二分找到右边界
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		int j = left;

		left = 0;
		right = nums.length-1;

		// 2. 二分找到左边界
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		int i = right;

		return j - i - 1;
	}
}
