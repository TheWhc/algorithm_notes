package 数组.二分法;

/**
 * @ClassName: _34_在排序数组中查找元素的第一个和最后一个位置
 * @Author: whc
 * @Date: 2021/07/01/10:21
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

	/**
	 * 思路: 二分查找
	 *
	 * 1. 寻找右边界
	 * 2. 寻找左边界
	 * 3. target出现在数组的左右边界的三种情况
	 * 		- target出现在数组范围的右边或者左边, 比如数组{3,4,5}, target=2
	 * 	  	- target出现在数组范围中,但数组中不存在target, 比如数组{3,6,7}, target=5
	 * 	   	- target出现在数组范围中,且数组中存在target, 例如数组{3,6,7}, target=6
	 */
	public int[] searchRange(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		// 查找目标值的右边界
		int rightBorder = -2;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > target) {
				right = mid - 1;
			} else {
				// nums[mid] <= target, 更新left,这样才能得到target的右边界
				left = mid + 1;
				rightBorder = left;
			}
		}

		left = 0;
		right = nums.length - 1;
		// 查找目标值的左边界
		int leftBorder = -2;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			} else {
				// nums[mid] >= target, 更新right,这样才能得到target的左边界
				right = mid - 1;
				leftBorder = right;
			}
		}

		// - target出现在数组范围的右边或者左边, 比如数组{3,4,5}, target=2
		if(leftBorder == -2 || rightBorder == -2) {
			return new int[]{-1, -1};
		} else if(rightBorder - leftBorder > 1) {
			// target出现在数组范围中,且数组中存在target, 例如数组{3,6,7}, target=6
			return new int[]{leftBorder + 1, rightBorder - 1};
		} else {
			// target出现在数组范围中,但数组中不存在target, 比如数组{3,6,7}, target=5
			return new int[]{-1, -1};
		}
	}
}
