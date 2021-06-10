package 待分类;

/**
 * @ClassName: 待分类._153_寻找旋转排序数组中的最小值
 * @Author: whc
 * @Date: 2021/03/25/13:16
 */
public class _153_寻找旋转排序数组中的最小值 {

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			if(nums[left] <= nums[right]) {
				return nums[left];
			}
			int mid = (left + right) >> 1;
			if(nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return -1;
	}

}
