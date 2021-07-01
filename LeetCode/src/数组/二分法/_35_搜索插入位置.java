package 数组.二分法;

/**
 * @ClassName: _35_搜索插入位置
 * @Author: whc
 * @Date: 2021/07/01/10:10
 */
public class _35_搜索插入位置 {

	/**
	 * 思路: 二分查找
	 *
	 * 左闭右闭区间 [left, right]
	 *
	 * 时间: O(logn)
	 * 空间: O(1)
	 */
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > target) {
				right = mid - 1;
			} else if(nums[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return left;
	}
}
