package CodeTop;

/**
 * @ClassName: _704_二分查找
 * @Author: whc
 * @Date: 2021/07/20/14:58
 */
public class _704_二分查找 {

	/**
	 *
	 * while (left <= right) 用在要找的数的性质简单的时候，把区间分成三个部分，在循环体内就可以返回；
	 */
	public int search(int[] nums, int target) {
		if(nums == null) {
			return -1;
		}
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			} else if(nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
