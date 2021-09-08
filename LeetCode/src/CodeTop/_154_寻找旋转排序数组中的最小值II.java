package CodeTop;

/**
 * @ClassName: _154_寻找旋转排序数组中的最小值II
 * @Author: whc
 * @Date: 2021/09/08/22:02
 */
public class _154_寻找旋转排序数组中的最小值II {

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			} else if(nums[mid] < nums[right]){
				right = mid;
			} else {
				// 重复元素
				right--;
			}
		}

		return nums[left];
	}
}
