package 二分法.二分下标;

/**
 * @ClassName: _35_搜索插入位置
 * @Author: whc
 * @Date: 2021/07/21/19:19
 */
public class _35_搜索插入位置 {

	public int searchInsert(int[] nums, int target) {
		// 特殊处理
		if(nums.length == 0 || nums[nums.length-1] < target) {
			return nums.length;
		}

		int left = 0;
		int right = nums.length -  1;

		while(left < right) {
			int mid = left + (right - left) / 2;
			// 向右逼近
			if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}
}
